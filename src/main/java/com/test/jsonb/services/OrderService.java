package com.test.jsonb.services;

import java.util.List;
import java.util.Optional;

import com.test.jsonb.dto.OrdersDto;
import com.test.jsonb.mapper.OrdersMapper;
import com.test.jsonb.models.Order;
import com.test.jsonb.repo.OrderRepo;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import javax.validation.Valid;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepo orderRepo;
    private OrdersMapper ordersMapper;
    public List<Order> findAllOrders() {
        return orderRepo.findAll();
    }

    public Order findOrderById(final String id) {

        Optional<Order> student = orderRepo.findById(id);
        if (!student.isPresent()) {
            throw new RuntimeException("Order not present");
        }
        return student.get();
    }

    public String saveOrders(@Valid OrdersDto ordersDto) {
        System.out.println(ordersDto.toString());
        Order entity = ordersMapper.toOrder(ordersDto);
        System.out.println(entity);
        orderRepo.save(entity);
        return "Added Successfully";
    }
}