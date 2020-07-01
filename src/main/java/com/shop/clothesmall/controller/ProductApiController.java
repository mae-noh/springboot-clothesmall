package com.shop.clothesmall.controller;

import com.shop.clothesmall.domain.Products.dto.productCategoryDetails.ProductCategoryDetailRequestDto;
import com.shop.clothesmall.domain.Products.dto.productCategoryDtos.ProductCategoryRequestDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.PageResponseDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductCreateRequestDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductUpdateRequestDto;
import com.shop.clothesmall.service.ProductCategoryDetailService;
import com.shop.clothesmall.service.ProductCategoryService;
import com.shop.clothesmall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;

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

    //list
    @GetMapping("/api/products")
    public PageResponseDto listProduct(@PageableDefault(size = 5, page = 0) Pageable pageable){
        return productService.list(pageable);
    }

    //delete
    @DeleteMapping("/api/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(id);
    }

}

