package com.shop.clothesmall.service;

import com.shop.clothesmall.domain.Products.ProductCategoryRepository;
import com.shop.clothesmall.domain.Products.dto.ProductCategoryRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

    public void create(ProductCategoryRequestDto productCategoryRequestDto){
        productCategoryRepository.save(productCategoryRequestDto.toEntity());
    }
}
