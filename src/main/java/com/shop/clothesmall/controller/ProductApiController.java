package com.shop.clothesmall.controller;

import com.shop.clothesmall.domain.Products.ProductRepository;
import com.shop.clothesmall.domain.Products.dto.productCategoryDetails.ProductCategoryDetailRequestDto;
import com.shop.clothesmall.domain.Products.dto.productCategoryDtos.ProductCategoryRequestDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductRequestDto;
import com.shop.clothesmall.service.ProductCategoryDetailService;
import com.shop.clothesmall.service.ProductCategoryService;
import com.shop.clothesmall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductCategoryService productCategoryService;
    private final ProductCategoryDetailService productCategoryDetailService;
    private final ProductService productService;

    //카테고리 create
    @PostMapping("/api/categories")
    public String createCategory(@RequestBody ProductCategoryRequestDto productCategoryRequestDto){
        productCategoryService.create(productCategoryRequestDto);
        return "OK";
    }

    //카테고리 디테일 create
    @PostMapping("api/categories/detail")
    public String createCategoryDetail(@RequestBody ProductCategoryDetailRequestDto productCategoryDetailRequestDto){
        productCategoryDetailService.create(productCategoryDetailRequestDto);
        return "OK";
    }

    //상품 create
    @PostMapping("/api/products")
    public String createProduct(@RequestBody ProductRequestDto productRequestDto){
        productService.create(productRequestDto);
        return "OK";
    }

    @PutMapping("/api/products/{id}")
    public String updateProduct(Long id, @RequestBody ProductRequestDto productRequestDto){
        productRequestDto.update(productRequestDto);
        return "OK";
    }

}
