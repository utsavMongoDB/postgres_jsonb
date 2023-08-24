package com.test.jsonb.repo;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.test.jsonb.dto.ProductDto;
import com.test.jsonb.models.Order;
import com.test.jsonb.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderRepo extends JpaRepository<Order, String> {

    // Get a total of orders based on order ID
    @Query(value = "SELECT sub_total FROM orders WHERE order_id = :orderId", nativeQuery = true)
    List<String> findSubTotalByOrderId(@Param("orderId") Integer orderId);

//    // Get total order amount in a given date range
//    @Query(value = "SELECT SUM(o.total_amount) AS total_order_amount " +
//            "FROM orders o " +
//            "JOIN users u ON o.user_id = u.user_id " +
//            "WHERE o.order_date BETWEEN :startDate AND :endDate " +
//            "GROUP BY u.username " +
//            "ORDER BY total_order_amount DESC ", nativeQuery = true)
//    List<Integer> getTotalOrderAmountInRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


    @Query(value = "SELECT product_id " +
            "FROM ( " +
            "    SELECT (jsonb_array_elements(order_item)->>'product_id')::::int AS product_id " +
            "    FROM orders " +
            "    WHERE order_date >= :startDate AND order_date <= :endDate " +
            ") AS extracted_products " +
            "GROUP BY product_id " +
            "ORDER BY COUNT(*) DESC " +
            "LIMIT 5",
            nativeQuery = true)
    List<Integer> findTopProductsInDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


    @Query(value =
            "SELECT " +
                    " jsonb_agg(p)::::text AS products " +
                    "FROM product p " +
                    "JOIN ( " +
                    "    SELECT DISTINCT (jsonb_array_elements(order_item)->>'product_id')::::int AS product_id " +
                    "    FROM orders " +
                    "    WHERE user_id = :userId " +
                    "    AND order_date BETWEEN :startDate AND :endDate " +
                    ") AS ordered_products " +
                    "ON p.product_id = ordered_products.product_id",
            nativeQuery = true)
    String findProductsOrderedByUserInDateRange(@Param("userId") int userId,
                                                       @Param("startDate") Date startDate,
                                                       @Param("endDate") Date endDate);

    @Query(value = "SELECT * FROM orders o WHERE o.delivery_details ->> 'shipment_id'= :shipmentId", nativeQuery = true)
    Order findByShipmentId(@Param("shipmentId") String shipmentId);


    @Transactional
    @Modifying
    @Query(value = "WITH updated_item AS (" +
            "    SELECT jsonb_set(item, '{order_item_status}', to_jsonb(:newOrderItemStatus), true) AS updated_item " +
            "    FROM (" +
            "        SELECT jsonb_array_elements(order_item) AS item " +
            "        FROM orders " +
            "        WHERE order_id = :orderId " +
            "    ) AS subquery" +
            ")" +
            "UPDATE orders " +
            "SET order_item = (SELECT jsonb_agg(updated_item) FROM updated_item) " +
            "WHERE order_id = :orderId",
            nativeQuery = true)
    void updateOrderItemStatus(@Param("orderId") int orderId, @Param("newOrderItemStatus") int newOrderItemStatus);
}
