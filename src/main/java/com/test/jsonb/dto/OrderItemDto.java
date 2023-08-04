package com.test.jsonb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderItemDto {
    @JsonProperty("order_item_id")
    private int orderItemId;

    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("rate")
    private int rate;

    @JsonProperty("total")
    private int total;

    @JsonProperty("order_item_status")
    private int orderItemStatus;
}