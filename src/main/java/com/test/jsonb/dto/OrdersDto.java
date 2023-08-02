package com.test.jsonb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

@Data
public class OrdersDto {

    @JsonProperty("orderId")
    private Long orderId;

    @JsonProperty("order_date")
    private LocalDate orderDate;

    @JsonProperty("client_name")
    private String clientName;

    @JsonProperty("client_contact")
    private String clientContact;

    @JsonProperty("sub_total")
    private String subTotal;

    @JsonProperty("vat")
    private String vat;

    @JsonProperty("total_amount")
    private String totalAmount;

    @JsonProperty("discount")
    private String discount;

    @JsonProperty("grand_total")
    private String grandTotal;

    @JsonProperty("paid")
    private String paid;

    @JsonProperty("due")
    private String due;

    @JsonProperty("payment_type")
    private int paymentType;

    @JsonProperty("payment_status")
    private int paymentStatus;

    @JsonProperty("payment_place")
    private int paymentPlace;

    @JsonProperty("gstn")
    private String gstn;

    @JsonProperty("order_status")
    private int orderStatus = 0;

    @JsonProperty("user_id")
    private Long user;

    @JsonProperty("order_item")
    private OrderItemDto[] orderItem;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientContact() {
        return clientContact;
    }

    public void setClientContact(String clientContact) {
        this.clientContact = clientContact;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public String getVat() {
        return vat;
    }

    public void setVat(String vat) {
        this.vat = vat;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(String grandTotal) {
        this.grandTotal = grandTotal;
    }

    public String getPaid() {
        return paid;
    }

    public void setPaid(String paid) {
        this.paid = paid;
    }

    public String getDue() {
        return due;
    }

    public void setDue(String due) {
        this.due = due;
    }

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public int getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(int paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getPaymentPlace() {
        return paymentPlace;
    }

    public void setPaymentPlace(int paymentPlace) {
        this.paymentPlace = paymentPlace;
    }

    public String getGstn() {
        return gstn;
    }

    public void setGstn(String gstn) {
        this.gstn = gstn;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long userId) {
        this.user = userId;
    }

    public OrderItemDto[] getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItemDto[] orderItem) {
        this.orderItem = orderItem;
    }
}
