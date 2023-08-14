package com.test.jsonb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OrdersDto {

    @JsonProperty("orderId")
    private Long orderId;

    @JsonProperty("order_date")
    private String orderDate;

    @JsonProperty("client_name")
    private String clientName;

    @JsonProperty("client_contact")
    private String clientContact;

    @JsonProperty("sub_total")
    private int subTotal;

    @JsonProperty("vat")
    private int vat;

    @JsonProperty("total_amount")
    private int totalAmount;

    @JsonProperty("discount")
    private int discount;

    @JsonProperty("grand_total")
    private int grandTotal;

    @JsonProperty("paid")
    private int paid;

    @JsonProperty("due")
    private int due;

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
    private Long userId;

    @JsonProperty("order_item")
    private List<Map<String, Object>> orderItem;

    @JsonProperty("delivery_details")
    private Map<String, Object> deliveryDetails;

}
