package com.test.jsonb.controllers;

import javax.validation.Valid;

import com.test.jsonb.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.jsonb.services.OrderService;

import java.util.List;


@RestController
@RequestMapping(value = "/inventory")
public class OrderController {
    
    @Autowired
    private OrderService OrderService;
    
//    @GetMapping
//    public List<Order> findAllOrders() {
//        return OrderService.findAllOrders();
//    }
//
//    @GetMapping("/{order_id}")
//    public Order findOrderByOrderId(@PathVariable @NotBlank final String id) {
//        return OrderService.findOrderById(id);
//    }
    
    @PostMapping("/orders")
    public String saveOrders(@RequestBody @Valid final OrdersDto ordersDto) {
        return OrderService.saveOrders(ordersDto);
    }

    @GetMapping("/test")
    public List<Object[]> getOrder() {
        return OrderService.getOrdersByUserId(1);
    }
}