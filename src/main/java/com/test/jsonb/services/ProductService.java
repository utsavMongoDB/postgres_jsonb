package com.test.jsonb.services;

import com.test.jsonb.dto.ProductDto;
import com.test.jsonb.dto.UserDto;
import com.test.jsonb.mapper.Mapper;
import com.test.jsonb.models.Product;
import com.test.jsonb.models.User;
import com.test.jsonb.repo.ProductRepo;
import com.test.jsonb.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Random;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private Mapper mapper;

    public String saveProduct(int productId) {
        ProductDto productDto = generateProductDto(productId);
        Product entity = mapper.toProduct(productDto);
        System.out.println(Arrays.toString(entity.getClass().getFields()));
        productRepo.save(entity);
        return "Added Product Successfully";
    }


    public static ProductDto generateProductDto(int productId) {
        ProductDto productDto = new ProductDto();
        productDto.setProduct_id((long) productId);
        productDto.setProduct_name("Product " + productId);
        productDto.setProduct_image("image" + productId + ".jpg");
        productDto.setBrand_id(generateRandomNumber(1, 10));
        productDto.setCategories_id(generateRandomNumber(1, 5));
        productDto.setQuantity(generateRandomNumber(1, 100));
        productDto.setRate(generateRandomNumber(10, 1000) );
        productDto.setActive(1);
        productDto.setStatus(0);

        return productDto;
    }

    private static int generateRandomNumber(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

}