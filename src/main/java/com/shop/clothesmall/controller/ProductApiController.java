package com.shop.clothesmall.controller;

import com.shop.clothesmall.domain.Products.ProductCategoryDetailRepository;
import com.shop.clothesmall.domain.Products.dto.ProductCategoryDetailRequestDto;
import com.shop.clothesmall.domain.Products.dto.ProductCategoryRequestDto;
import com.shop.clothesmall.service.ProductCategoryDetailService;
import com.shop.clothesmall.service.ProductCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductCategoryService productCategoryService;
    private final ProductCategoryDetailService productCategoryDetailService;

    //카테고리
    @PostMapping("/api/categories")
    public String createCategory(@RequestBody ProductCategoryRequestDto productCategoryRequestDto){
        productCategoryService.create(productCategoryRequestDto);
        return "OK";
    }

    //카테고리 디테일
    @PostMapping("api/categories/detail")
    public String createCategoryDetail(@RequestBody ProductCategoryDetailRequestDto productCategoryDetailRequestDto){
        productCategoryDetailService.create(productCategoryDetailRequestDto);
        return "OK";
    }

}
