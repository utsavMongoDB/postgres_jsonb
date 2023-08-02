package com.test.jsonb.models;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "product_image", nullable = false, columnDefinition = "TEXT")
    private String productImage;

    @Column(name = "brand_id", nullable = false)
    private Integer brandId;

    @Column(name = "categories_id", nullable = false)
    private Integer categoriesId;

    @Column(name = "quantity", nullable = false)
    private String quantity;

    @Column(name = "rate", nullable = false)
    private String rate;

    @Column(name = "active", nullable = false)
    private Integer active = 0;

    @Column(name = "status", nullable = false)
    private Integer status = 0;

}
