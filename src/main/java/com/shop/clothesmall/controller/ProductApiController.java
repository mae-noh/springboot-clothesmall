package com.shop.clothesmall.controller;

import com.shop.clothesmall.domain.Products.dto.page.PageRequestDto;
import com.shop.clothesmall.domain.Products.dto.page.PageResponseDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductCreateRequestDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductCreateResponseDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductUpdateRequestDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductUpdateResponseDto;
import com.shop.clothesmall.domain.common.ApiResponseTemplate;
import com.shop.clothesmall.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ProductApiController {

    private final ProductService productService;

    //create
    @PostMapping("/api/products")
    public ApiResponseTemplate<ProductCreateResponseDto> createProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto) {
        return ApiResponseTemplate.ok(productService.create(productCreateRequestDto));
    }

    //update
    @PatchMapping("/api/products/{id}")
    public ApiResponseTemplate<ProductUpdateResponseDto> updateProduct(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto) {
        return ApiResponseTemplate.ok(productService.update(id, productUpdateRequestDto));
    }

    //list
    @GetMapping("/api/products")
    public ApiResponseTemplate<PageResponseDto> listProduct(@RequestParam(value = "page") int page,
                                                            @RequestParam(value = "size") int size){
        PageRequestDto pageRequestDto = PageRequestDto.builder()
                .page(page)
                .size(size)
                .build();

        return ApiResponseTemplate.ok(productService.list(pageRequestDto));
    }

    //delete
    @DeleteMapping("/api/products/{id}")
    public ApiResponseTemplate deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return ApiResponseTemplate.ok();
    }

}

