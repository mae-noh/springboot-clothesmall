package com.shop.clothesmall.service;

import com.shop.clothesmall.domain.Products.ProductRepository;
import com.shop.clothesmall.domain.Products.dto.ProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void create(ProductRequestDto productRequestDto){
        productRepository.save(productRequestDto.toEntity());
    }

}
