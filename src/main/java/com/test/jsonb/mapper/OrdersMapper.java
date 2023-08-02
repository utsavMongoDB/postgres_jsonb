package com.test.jsonb.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.jsonb.dto.*;
import com.test.jsonb.models.Order;
import com.test.jsonb.models.OrderItem;
import com.test.jsonb.models.Product;
import com.test.jsonb.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface OrdersMapper {
    OrdersDto toOrderDto(Order orders);
    Order toOrder(OrdersDto ordersDto);

    UserDto toUserDto(User user);
    User toUser(UserDto userDto);

    OrderItemDto toOrderItem(OrderItem orderItem);
    OrderItem toOrdersItemDto(OrderItemDto orderItemDto);

    ProductDto toProductDto(Product product);
    Product toProduct(ProductDto productDto);


}