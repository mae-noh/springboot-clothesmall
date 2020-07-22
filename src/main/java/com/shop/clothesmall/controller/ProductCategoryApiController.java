package com.shop.clothesmall.controller;

import com.shop.clothesmall.domain.Products.dto.productCategoryDtos.ProductCategoryRequestDto;
import com.shop.clothesmall.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductCategoryApiController {

    private final ProductCategoryService productCategoryService;

    @PostMapping("/api/categories")
    public String createCategory(@RequestBody ProductCategoryRequestDto productCategoryRequestDto) {
        productCategoryService.create(productCategoryRequestDto);
        return "OK";
    }
}
