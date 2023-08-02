package com.test.jsonb.dto;

import lombok.Data;

@Data
public class OrdersDataDto {
    private Long order_data_id;
    private String customer_name;
    private Integer total_value;
    private OrderItemDto[] orderItem;

    public Long getOrder_data_id() {
        return order_data_id;
    }

    public void setOrder_data_id(Long order_data_id) {
        this.order_data_id = order_data_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Integer getTotal_value() {
        return total_value;
    }

    public void setTotal_value(Integer total_value) {
        this.total_value = total_value;
    }

    public OrderItemDto[] getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItemDto[] orderItem) {
        this.orderItem = orderItem;
    }
}
