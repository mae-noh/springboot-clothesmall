package com.shop.clothesmall.controller;

import com.shop.clothesmall.domain.Products.dto.productCategoryDetails.ProductCategoryDetailRequestDto;
import com.shop.clothesmall.service.ProductCategoryDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ProductCategoryDetailApiController {

    private final ProductCategoryDetailService productCategoryDetailService;

    @PostMapping("api/categories/detail")
    public String createCategoryDetail(@RequestBody ProductCategoryDetailRequestDto productCategoryDetailRequestDto) {
        productCategoryDetailService.create(productCategoryDetailRequestDto);
        return "OK";
    }

}
