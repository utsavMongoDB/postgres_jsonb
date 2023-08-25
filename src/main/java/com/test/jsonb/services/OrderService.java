package com.test.jsonb.services;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.jsonb.dto.OrdersDto;
import com.test.jsonb.mapper.Mapper;
import com.test.jsonb.models.Order;
import com.test.jsonb.repo.OrderRepo;
import com.test.jsonb.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private Mapper mapper;
    @Autowired
    private ObjectMapper objectMapper;

    public List<Order> findAllOrders() {
        return orderRepo.findAll();
    }

    public String updateOrderItemStatus(int orderId, int newOrderItemStatus) {
        orderRepo.updateOrderItemStatus(orderId, newOrderItemStatus);
        System.out.println("orderId:" + orderId);
        return "Order modified: " + orderId;
    }

//    public List<Integer> getTotalOrderAmountInRange(Date startDate, Date endDate) {
//        return orderRepo.getTotalOrderAmountInRange(startDate, endDate);
//    }

    public List<Integer> findTopProductsInDateRange(Date startDate, Date endDate) {
        return orderRepo.findTopProductsInDateRange(startDate, endDate);
    }

    public Order saveOrders(Long orderId) {
        OrdersDto ordersDto = generateOrdersDto(orderId);
        Order entity = mapper.toOrder(ordersDto);
        return orderRepo.save(entity);
    }

    public Object findOrderById(String id) {
        return orderRepo.findById(id);
    }


    public static OrdersDto generateOrdersDto(Long orderId) {
        Random random = new Random();

        LocalDate startDate = LocalDate.of(2023, 7, 15);
        LocalDate endDate = LocalDate.of(2023, 7, 31);
        LocalDate orderDate = generateRandomDate(startDate, endDate);

        String clientName = "client_" + orderId;
        String clientContact = "+1-555-" + random.nextInt(1000) + "-" + random.nextInt(10000);
        int subTotal = generateRandomNumber(100, 1000);
        int vat = subTotal / 10;
        int totalAmount = subTotal + vat;
        int discount = generateRandomNumber(0, 50);
        int grandTotal = totalAmount - discount;
        int paid = grandTotal;
        int due = 0;
        int paymentType = random.nextInt(2) + 1;
        int paymentStatus = random.nextInt(2) + 1;
        int paymentPlace = random.nextInt(2) + 1;
        String gstn = generateRandomGSTN();
        int orderStatus = 0;
        Long userId = (long) generateRandomNumber(1, 10000);
        List<Map<String, Object>> orderItems = generateRandomOrderItems();

        OrdersDto ordersDto = new OrdersDto();
        ordersDto.setOrderId(orderId);
        ordersDto.setOrderDate(String.valueOf(orderDate));
        ordersDto.setClientName(clientName);
        ordersDto.setClientContact(clientContact);
        ordersDto.setSubTotal(subTotal);
        ordersDto.setVat(vat);
        ordersDto.setTotalAmount(totalAmount);
        ordersDto.setDiscount(discount);
        ordersDto.setGrandTotal(grandTotal);
        ordersDto.setPaid(paid);
        ordersDto.setDue(due);
        ordersDto.setPaymentType(paymentType);
        ordersDto.setPaymentStatus(paymentStatus);
        ordersDto.setPaymentPlace(paymentPlace);
        ordersDto.setGstn(gstn);
        ordersDto.setOrderStatus(orderStatus);
        ordersDto.setUserId(userId);
        ordersDto.setOrderItem(orderItems);
        ordersDto.setDeliveryDetails(generateDeliveryDetails(orderId));
        return ordersDto;
    }

    private static final String GSTN_PREFIX = "GSTN";

    private static LocalDate generateRandomDate(LocalDate startDate, LocalDate endDate) {
        long startEpochDay = startDate.toEpochDay();
        long endEpochDay = endDate.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);
        return LocalDate.ofEpochDay(randomDay);
    }

    private static String generateRandomGSTN() {
        int number = generateRandomNumber(1000, 9999);
        return GSTN_PREFIX + number;
    }

    private static List<Map<String, Object>> generateRandomOrderItems() {
        Random random = new Random();
        int itemCount = random.nextInt(3) + 3; // Generate between 3 and 5 items

        List<Map<String, Object>> orderItems = new ArrayList<>();
        for (int i = 0; i < itemCount; i++) {
            Map<String, Object> orderItem = new HashMap<>();
            orderItem.put("order_item_id", i);
            orderItem.put("product_id", generateRandomNumber(1, 10000));
            orderItem.put("quantity", random.nextInt(5) + 1);
            orderItem.put("rate", generateRandomNumber(50, 200));
            orderItem.put("total", (int) orderItem.get("quantity") * (int) orderItem.get("rate"));
            orderItem.put("order_item_status", random.nextInt(2));
            orderItems.add(orderItem);
        }

        return orderItems;
    }

    private static Map<String, Object> generateDeliveryDetails(Long orderId) {
        Random random = new Random();
        Map<String, Object> orderItem = new HashMap<>();
        orderItem.put("shipment_id", orderId);
        orderItem.put("log_com_code", generateRandomNumber(1, 100));
        orderItem.put("delivery_status", random.nextInt(2));

        return orderItem;
    }


    private static int generateRandomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }
}