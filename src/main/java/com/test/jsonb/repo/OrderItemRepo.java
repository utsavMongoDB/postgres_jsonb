package com.test.jsonb.repo;

import com.test.jsonb.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepo extends JpaRepository<OrderItem, String> {

    @Query(value = "SELECT order_items.* " +
            "FROM orders " +
            "INNER JOIN order_items ON orders.order_id = order_items.order_id " +
            "WHERE orders.delivery_details ->> 'shipment_id'= :shipmentId", nativeQuery = true)
    List<OrderItem> findOrdersByShipmentId_v2(@Param("shipmentId") String shipmentId);
}