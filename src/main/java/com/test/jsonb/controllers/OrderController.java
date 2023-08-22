package com.test.jsonb.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.jsonb.models.Order;
import com.test.jsonb.repo.OrderRepo;
import com.test.jsonb.utils.DateGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.test.jsonb.services.OrderService;

import java.util.*;


@RestController
@RequestMapping(value = "/inventory")
public class OrderController {
    
    @Autowired
    private OrderService OrderService;
    @Autowired
    private OrderRepo orderRepo;

    Random random = new Random();

    /**
     * Add Orders using an order ID; randomized data is generated using the ID
     * @param orderId
     * @return
     */
    @PostMapping("/add/{orderId}")
    public Order saveOrders(@PathVariable Long orderId) {
        return OrderService.saveOrders(orderId);
    }

    /**
     * Find all products ordered by a user in a particular date range
     *
     * @param userId
     * @return
     */
    @GetMapping("/get/{userId}")
    public JsonNode findProductsOrderedByUserInDateRange(@PathVariable int userId) {
        try {
            Date randomStartDate = DateGenerator.generateRandomStartDate();
            Date randomEndDate = DateGenerator.generateRandomEndDate(randomStartDate);
            String query_result = orderRepo.findProductsOrderedByUserInDateRange(userId, randomStartDate, randomEndDate);
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readTree(query_result);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    /**
//     * Returns list of all users in the database with the total order amount ordered,
//     * ORDERED by order amount
//     * @return
//     */
//    @GetMapping("/getOrderAmount")
//    public List<Integer> getTotalOrderAmountInRange() {
//        try {
//            Date randomStartDate = DateGenerator.generateRandomStartDate();
//            Date randomEndDate = DateGenerator.generateRandomEndDate(randomStartDate);
//            return OrderService.getTotalOrderAmountInRange(randomStartDate, randomEndDate);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


    /**
     * Find top 5 products in a given date range.
     * @return
     */
    @GetMapping("/findTopProducts")
    public List<Integer> findTopProductsInDateRange() {
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

    @GetMapping("/findByShipmentId/{shipmentId}")
    public Order findByShipmentId(@PathVariable String shipmentId) {
        return orderRepo.findByShipmentId(shipmentId);
    }
}
