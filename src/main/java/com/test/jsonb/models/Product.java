package com.test.jsonb.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long product_id;

    @Column(name = "product_name", nullable = false)
    private String product_name;

    @Column(name = "product_image", nullable = false, columnDefinition = "TEXT")
    private String product_image;

    @Column(name = "brand_id", nullable = false)
    private Integer brand_id;

    @Column(name = "categories_id", nullable = false)
    private Integer categories_id;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "rate", nullable = false)
    private Integer rate;

    @Column(name = "active", nullable = false)
    private Integer active = 0;

    @Column(name = "status", nullable = false)
    private Integer status = 0;

}
