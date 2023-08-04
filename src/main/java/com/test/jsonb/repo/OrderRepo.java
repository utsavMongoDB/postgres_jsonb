package com.test.jsonb.repo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.test.jsonb.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, String> {

    // Get a total of orders based on order ID
    @Query(value = "SELECT sub_total FROM orders WHERE order_id = :orderId", nativeQuery = true)
    List<String> findSubTotalByOrderId(@Param("orderId") Integer orderId);

    // Get total order amount in a given date range
    @Query(value = "SELECT u.username, SUM(o.total_amount) AS total_order_amount " +
            "FROM orders o " +
            "JOIN users u ON o.user_id = u.user_id " +
            "WHERE o.order_date BETWEEN :startDate AND :endDate " +
            "GROUP BY u.username", nativeQuery = true)
    List<String> getTotalOrderAmountInRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


    // TODO: Top 5 products, items in Date range.
    @Query(value = "SELECT product_id, COUNT(*) AS order_count " +
            "FROM ( " +
            "    SELECT (jsonb_array_elements(order_item)->>'product_id')::::int AS product_id " +
            "    FROM orders " +
            "    WHERE order_date >= :startDate AND order_date <= :endDate " +
            ") AS extracted_products " +
            "GROUP BY product_id " +
            "ORDER BY order_count DESC " +
            "LIMIT 5", nativeQuery = true)
    List<Object[]> findTopProductsInDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);


    @Query(value = "SELECT o.sub_total " +
            "FROM orders o " +
            "CROSS JOIN jsonb_array_elements(o.order_item) AS item " +
            "WHERE (item->>'order_item_id')::::int = :orderItemId", nativeQuery = true)
    String getOrdersByUserId(@Param("orderItemId") Integer orderItemId);

}