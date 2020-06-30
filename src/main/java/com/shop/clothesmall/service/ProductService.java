package com.shop.clothesmall.service;

import com.shop.clothesmall.domain.Products.Product;
import com.shop.clothesmall.domain.Products.ProductRepository;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void create(ProductRequestDto productRequestDto){
        productRepository.save(productRequestDto.toEntity());
    }

    public void update(Long id, ProductRequestDto productRequestDto) {
        Product product = productRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("사용자가 존재하지 않습니다."));

    }
}
