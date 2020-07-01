package com.shop.clothesmall.controller;

import com.shop.clothesmall.domain.Products.dto.productCategoryDetails.ProductCategoryDetailRequestDto;
import com.shop.clothesmall.domain.Products.dto.productCategoryDtos.ProductCategoryRequestDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductCreateRequestDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductUpdateRequestDto;
import com.shop.clothesmall.service.ProductCategoryDetailService;
import com.shop.clothesmall.service.ProductCategoryService;
import com.shop.clothesmall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductCategoryService productCategoryService;
    private final ProductCategoryDetailService productCategoryDetailService;
    private final ProductService productService;

    //카테고리
    //create
    @PostMapping("/api/categories")
    public String createCategory(@RequestBody ProductCategoryRequestDto productCategoryRequestDto) {
        productCategoryService.create(productCategoryRequestDto);
        return "OK";
    }

    //카테고리 디테일
    //create
    @PostMapping("api/categories/detail")
    public String createCategoryDetail(@RequestBody ProductCategoryDetailRequestDto productCategoryDetailRequestDto) {
        productCategoryDetailService.create(productCategoryDetailRequestDto);
        return "OK";
    }

    //상품
    //create
    @PostMapping("/api/products")
    public String createProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto) {
        productService.create(productCreateRequestDto);
        return "OK";
    }

    //update
    @PatchMapping("/api/products/{id}")
    public String updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto) {
        productService.update(id, productUpdateRequestDto);
        return "OK";
    }

//    //list
//    @GetMapping("/api/products")
//    public String listProduct(@RequestBody PageRequest pageRequest){
//
//    }

}

