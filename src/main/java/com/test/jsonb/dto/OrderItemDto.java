package com.test.jsonb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrderItemDto {
    @JsonProperty("order_item_id")
    private Long orderItemId;

    @JsonProperty("order_id")
    private Long orderId;

    @JsonProperty("product_id")
    private Long productId;

    @JsonProperty("quantity")
    private Integer product_id;

    @JsonProperty("rate")
    private String rate;

    @JsonProperty("total")
    private String total;

    @JsonProperty("order_item_status")
    private Integer orderItemStatus = 0;
}