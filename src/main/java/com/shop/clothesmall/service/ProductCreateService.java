package com.shop.clothesmall.service;

import com.shop.clothesmall.doamin.Products.Product;
import com.shop.clothesmall.doamin.Products.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductCreateService {

    private final ProductRepository productRepository;

    public void create(Product product){
        productRepository.save(product);
    }

}
