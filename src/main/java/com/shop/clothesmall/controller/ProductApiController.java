package com.shop.clothesmall.controller;

import com.shop.clothesmall.domain.Products.dto.page.PageResponseDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.*;
import com.shop.clothesmall.domain.common.ApiResponseTemplate;
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
    public ApiResponseTemplate<ProductCreateResponseDto> createProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto) {
        return productService.create(productCreateRequestDto);
    }

    //update
    @PatchMapping("/api/products/{id}")
    public ApiResponseTemplate<ProductUpdateResponseDto> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto) {
        return productService.update(id, productUpdateRequestDto);
    }

    //list
    @GetMapping("/api/products")
    public ApiResponseTemplate<ProductListResponseDto> listProduct(@PageableDefault(size = 5, page = 0) Pageable pageable){
        return productService.list(pageable);
    }

    //delete
    @DeleteMapping("/api/products/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.delete(id);
    }

}

