package com.test.jsonb.controllers;

import javax.validation.Valid;

import com.test.jsonb.dto.OrderItemDto;
import com.test.jsonb.dto.OrdersDto;
import com.test.jsonb.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.test.jsonb.services.OrderService;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


@RestController
@RequestMapping(value = "/inventory")
public class OrderController {
    
    @Autowired
    private OrderService OrderService;

    @PostMapping("/add/{orderId}")
    public String saveOrders(@PathVariable int orderId) {
        return OrderService.saveOrders(orderId);
    }

    @GetMapping("/all")
    public List<Order> findAllOrders() {
        return OrderService.findAllOrders();
    }

    @GetMapping("/{order_id}")
    public Object findOrderByOrderId(@PathVariable final String id) {
        return OrderService.findOrderById(id);
    }

    @GetMapping("/test")
    public String getOrder() {
        return OrderService.getOrdersByUserId(101);
    }

    @GetMapping("/getOrderAmount/{startDate}/{endDate}")
    public List<String> getTotalOrderAmountInRange(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return OrderService.getTotalOrderAmountInRange(startDate, endDate);
    }

    @GetMapping("/findTopProducts/{startDate}/{endDate}")
    public List<Object[]> findTopProductsInDateRange(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        return OrderService.findTopProductsInDateRange(startDate, endDate);
    }

}
