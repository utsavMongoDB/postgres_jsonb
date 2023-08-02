package com.test.jsonb.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.jsonb.dto.*;
import com.test.jsonb.models.Order;
import com.test.jsonb.models.OrderItem;
import com.test.jsonb.models.Product;
import com.test.jsonb.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface OrdersMapper {
    @Mapping(target = "orderId", source = "orderId")
    Order toOrder(OrdersDto ordersDto);

    OrderItem toOrdersItem(OrderItemDto orderItemDto);
    OrderItemDto toOrderItemDto(OrderItem orderItem);

}