package com.test.jsonb.services;

import java.util.List;
import java.util.Optional;

import com.test.jsonb.dto.OrdersDto;
import com.test.jsonb.mapper.OrdersMapper;
import com.test.jsonb.models.Order;
import com.test.jsonb.repo.OrderRepo;
import org.hibernate.jpa.TypedParameterValue;
import org.hibernate.type.IntegerType;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderRepo orderRepo;
    private OrdersMapper ordersMapper;
    public List<Order> findAllOrders() {
        return orderRepo.findAll();
    }

    @PersistenceContext
    private EntityManager entityManager;

    public Order findOrderById(final String id) {

        Optional<Order> student = orderRepo.findById(id);
        if (!student.isPresent()) {
            throw new RuntimeException("Order not present");
        }
        return student.get();
    }

    public List<Object[]> getOrdersByUserId(int orderItemId) {
        String sqlQuery = "SELECT o.sub_total FROM orders o CROSS JOIN jsonb_array_elements(o.order_item) AS item WHERE (item->>'order_item_id')::int = :order_id";

        return entityManager.createNativeQuery(sqlQuery)
                .setParameter("order_id", new TypedParameterValue(IntegerType.INSTANCE, orderItemId))
                .getResultList();
    }

    public String saveOrders(@Valid OrdersDto ordersDto) {
        System.out.println(ordersDto.toString());
        Order entity = ordersMapper.toOrder(ordersDto);
        System.out.println(entity);
        orderRepo.save(entity);
        return "Added Successfully";
    }
}