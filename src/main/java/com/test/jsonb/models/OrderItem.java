package com.test.jsonb.models;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.Data;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Map;

@Data
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private Integer orderItemId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "rate")
    private Integer rate;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total")
    private Integer total;

    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_item_status")
    private Integer orderItemStatus;
}