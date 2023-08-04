package com.test.jsonb.controllers;


import com.test.jsonb.dto.ProductDto;
import com.test.jsonb.dto.UserDto;
import com.test.jsonb.services.ProductService;
import com.test.jsonb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping("/add/{productId}")
    public String saveProduct(@PathVariable int productId) {
        return productService.saveProduct(productId);
    }
}
