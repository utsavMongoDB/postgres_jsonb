package com.test.jsonb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class OrdersDto {

    @JsonProperty("orderId")
    private Long orderId;

    @JsonProperty("order_date")
    private LocalDate orderDate;

    @JsonProperty("client_name")
    private String clientName;

    @JsonProperty("client_contact")
    private String clientContact;

    @JsonProperty("sub_total")
    private String subTotal;

    @JsonProperty("vat")
    private String vat;

    @JsonProperty("total_amount")
    private String totalAmount;

    @JsonProperty("discount")
    private String discount;

    @JsonProperty("grand_total")
    private String grandTotal;

    @JsonProperty("paid")
    private String paid;

    @JsonProperty("due")
    private String due;

    @JsonProperty("payment_type")
    private int paymentType;

    @JsonProperty("payment_status")
    private int paymentStatus;

    @JsonProperty("payment_place")
    private int paymentPlace;

    @JsonProperty("gstn")
    private String gstn;

    @JsonProperty("order_status")
    private int orderStatus = 0;

    @JsonProperty("user_id")
    private Long user_id;

    @JsonProperty("order_item")
//    private OrderItemDto[] order_item;
    private List<Map<String, Object>> order_item;

}