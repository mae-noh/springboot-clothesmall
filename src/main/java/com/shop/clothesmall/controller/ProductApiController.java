package com.shop.clothesmall.controller;

import com.shop.clothesmall.domain.Products.dto.ProductCreateRequestDto;
import com.shop.clothesmall.domain.common.ResponseCheck;
import com.shop.clothesmall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductApiController{

    private final ProductService productService;

    @PostMapping("api/products")
    public void create(@RequestBody ProductCreateRequestDto productCreateRequestDto){
        productService.create(productCreateRequestDto);
    }

}
