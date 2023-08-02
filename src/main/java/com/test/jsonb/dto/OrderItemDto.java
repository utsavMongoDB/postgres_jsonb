package com.test.jsonb.dto;

import lombok.Data;

@Data
public class OrderItemDto {
    private Long orderItemId;
    private Long orderId;
    private ProductDto product;
    private String quantity;
    private String rate;
    private String total;
    private Integer orderItemStatus = 0;
}