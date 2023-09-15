package com.test.jsonb.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;

import lombok.Data;

@Data
@Entity
@Table(name = "orders")
@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
public class Order {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "client_contact", nullable = false)
    private String clientContact;

    @Column(name = "sub_total", nullable = false)
    private int subTotal;

    @Column(name = "vat", nullable = false)
    private int vat;

    @Column(name = "total_amount", nullable = false)
    private int totalAmount;

    @Column(name = "discount", nullable = false)
    private int discount;

    @Column(name = "grand_total", nullable = false)
    private int grandTotal;

    @Column(name = "paid", nullable = false)
    private int paid;

    @Column(name = "due", nullable = false)
    private int due;

    @Column(name = "payment_type", nullable = false)
    private int paymentType;

    @Column(name = "payment_status", nullable = false)
    private int paymentStatus;

    @Column(name = "payment_place", nullable = false)
    private int paymentPlace;

    @Column(name = "gstn", nullable = false)
    private String gstn;

    @Column(name = "order_status", nullable = false)
    private int orderStatus = 0;

    @Column(name = "user_id", nullable = false)
    private Long userId;

//    @Type(type = "jsonb")
//    @Column(name = "order_item", columnDefinition = "jsonb")
//    private List<Map<String, Object>> orderItem;

    @Type(type = "jsonb")
    @Column(name = "delivery_details", columnDefinition = "jsonb")
    private Map<String, Object> deliveryDetails;
}