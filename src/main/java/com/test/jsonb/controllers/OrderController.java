package com.test.jsonb.controllers;

import com.test.jsonb.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.test.jsonb.services.OrderService;

import java.util.*;


@RestController
@RequestMapping(value = "/inventory")
public class OrderController {
    
    @Autowired
    private OrderService OrderService;

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
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping("/get/{userId}/{startDate}/{endDate}")
    public List<Object[]> findProductsOrderedByUserInDateRange(@PathVariable int userId,
                                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                              @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return OrderService.findProductsOrderedByUserInDateRange(userId, startDate, endDate);
    }

    /**
     * Returns list of all users in the database with the total order amount ordered,
     * ORDERED by order amount
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping("/getOrderAmount/{startDate}/{endDate}")
    public List<String> getTotalOrderAmountInRange(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return OrderService.getTotalOrderAmountInRange(startDate, endDate);
    }


    /**
     * Find top 5 products in a given date range.
     * @param startDate
     * @param endDate
     * @return
     */
    @GetMapping("/findTopProducts/{startDate}/{endDate}")
    public List<Object[]> findTopProductsInDateRange(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return OrderService.findTopProductsInDateRange(startDate, endDate);
    }

}
