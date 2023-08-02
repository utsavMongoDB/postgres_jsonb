package com.test.jsonb.dto;

import lombok.Data;

@Data
public class ProductDto {
    private Long productId;
    private String productName;
    private String productImage;
    private Integer brandId;
    private Integer categoriesId;
    private String quantity;
    private String rate;
    private Integer active = 0;
    private Integer status = 0;
}
