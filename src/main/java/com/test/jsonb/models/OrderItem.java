package com.test.jsonb.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Long orderItemId;

    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "quantity", nullable = false)
    private String quantity;

    @Column(name = "rate", nullable = false)
    private String rate;

    @Column(name = "total", nullable = false)
    private String total;

    @Column(name = "order_item_status", nullable = false)
    private Integer orderItemStatus = 0;
}