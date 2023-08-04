package com.test.jsonb.mapper;

import com.test.jsonb.dto.*;
import com.test.jsonb.models.Order;
import com.test.jsonb.models.Product;
import com.test.jsonb.models.User;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;

@org.mapstruct.Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)

public interface Mapper {
    @Mapping(target = "orderId", source = "orderId")
    Order toOrder(OrdersDto ordersDto);


    User toUser(UserDto userDto);

    Product toProduct(ProductDto productDto);
}