package com.test.jsonb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OrdersItemDto {
    @JsonProperty("order_item_id")
    private Integer orderItemId;

    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("rate")
    private Integer rate;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("total")
    private Integer total;

    @JsonProperty("order_id")
    private Integer orderId;

    @JsonProperty("order_item_status")
    private Integer orderItemStatus;
}
