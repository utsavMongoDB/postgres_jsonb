package com.test.jsonb.services;

import com.test.jsonb.dto.OrdersDto;
import com.test.jsonb.dto.OrdersItemDto;
import com.test.jsonb.dto.UserDto;
import com.test.jsonb.mapper.Mapper;
import com.test.jsonb.models.Order;
import com.test.jsonb.models.OrderItem;
import com.test.jsonb.models.User;
import com.test.jsonb.repo.OrderItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepo orderItemRepo;
    @Autowired
    private Mapper mapper;
    @Autowired
    static Random random = new Random();

    public String saveOrderItem(int orderId) {
        System.out.println(orderId);
        int itemCount = 100;
        for (int itemId = 0; itemId < itemCount; itemId++) {
            OrdersItemDto ordersItemDto = generateRandomOrderItems(orderId);
            OrderItem entity = mapper.toOrderItem(ordersItemDto);
            orderItemRepo.save(entity);
        }
        return "Added OrderItems Successfully";
    }

    private static OrdersItemDto generateRandomOrderItems(int orderId) {
        int product_id = generateRandomNumber(1, 10000);
        int quantity = random.nextInt(5) + 1;
        int rate = generateRandomNumber(50, 200);
        int total = quantity * rate;
        int order_item_status = random.nextInt(2);

        OrdersItemDto ordersItemDto = new OrdersItemDto();
//        ordersItemDto.setOrderItemId(itemId);
        ordersItemDto.setRate(rate);
        ordersItemDto.setQuantity(quantity);
        ordersItemDto.setTotal(total);
        ordersItemDto.setOrderItemStatus(order_item_status);
        ordersItemDto.setProductId(product_id);
        ordersItemDto.setOrderId(orderId);

        return ordersItemDto;
    }

    private static int generateRandomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }



}
