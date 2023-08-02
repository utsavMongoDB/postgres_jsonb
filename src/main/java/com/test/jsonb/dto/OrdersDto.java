package com.test.jsonb.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class OrdersDto {
    private Long orderId;
    private LocalDate orderDate;
    private String clientName;
    private String clientContact;
    private String subTotal;
    private String vat;
    private String totalAmount;
    private String discount;
    private String grandTotal;
    private String paid;
    private String due;
    private int paymentType;
    private int paymentStatus;
    private int paymentPlace;
    private String gstn;
    private int orderStatus = 0;
    private UserDto user;
    private OrderItemDto order_item;
}