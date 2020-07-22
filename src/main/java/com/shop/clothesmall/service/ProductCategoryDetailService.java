package com.shop.clothesmall.service;

import com.shop.clothesmall.domain.Products.ProductCategoryDetailRepository;
import com.shop.clothesmall.domain.Products.dto.productCategoryDetails.ProductCategoryDetailRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductCategoryDetailService {
    private final ProductCategoryDetailRepository productCategoryDetailRepository;

    public void create(ProductCategoryDetailRequestDto productCategoryDetailRequestDto){
        productCategoryDetailRepository.save(productCategoryDetailRequestDto.toEntity());
    }
}
