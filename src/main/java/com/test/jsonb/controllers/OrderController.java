package com.test.jsonb.controllers;

import com.test.jsonb.models.Order;
import com.test.jsonb.utils.DateGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.test.jsonb.services.OrderService;

import java.util.*;
import java.util.random.RandomGenerator;


@RestController
@RequestMapping(value = "/inventory")
public class OrderController {
    
    @Autowired
    private OrderService OrderService;

    Random random = new Random();

    /**
     * Add Orders using an order ID; randomized data is generated using the ID
     * @param orderId
     * @return
     */
    @PostMapping("/add/{orderId}")
    public String saveOrders(@PathVariable int orderId) {
        return OrderService.saveOrders(orderId);
    }

    /**
     * Returns all orders in the Database
     * @return
     */
    @GetMapping("/all")
    public List<Order> findAllOrders() {
        return OrderService.findAllOrders();
    }

    /**
     * Find all products ordered by a user in a particular date range
     * @param userId
     * @return
     */
    @GetMapping("/get/{userId}")
    public List<Object[]> findProductsOrderedByUserInDateRange(@PathVariable int userId) {
        try {
            Date randomStartDate = DateGenerator.generateRandomStartDate();
            Date randomEndDate = DateGenerator.generateRandomEndDate(randomStartDate);
            return OrderService.findProductsOrderedByUserInDateRange(userId, randomStartDate, randomEndDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Returns list of all users in the database with the total order amount ordered,
     * ORDERED by order amount
     * @return
     */
    @GetMapping("/getOrderAmount")
    public List<String> getTotalOrderAmountInRange() {
        try {
            Date randomStartDate = DateGenerator.generateRandomStartDate();
            Date randomEndDate = DateGenerator.generateRandomEndDate(randomStartDate);
            return OrderService.getTotalOrderAmountInRange(randomStartDate, randomEndDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Find top 5 products in a given date range.
     * @return
     */
    @GetMapping("/findTopProducts")
    public List<Object[]> findTopProductsInDateRange() {
        try {
            Date randomStartDate = DateGenerator.generateRandomStartDate();
            Date randomEndDate = DateGenerator.generateRandomEndDate(randomStartDate);
            return OrderService.findTopProductsInDateRange(randomStartDate, randomEndDate);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    /**
     * Update the order status for a orderId in JSONB array
     * @param orderId
     * @return
     */
    @PutMapping("/updateOrderItemStatus/{orderId}")
    public String updateOrderItemStatus(
            @PathVariable int orderId
    ) {
        int orderStatus = random.nextInt(100);
        return OrderService.updateOrderItemStatus(orderId, orderStatus);
    }
}
