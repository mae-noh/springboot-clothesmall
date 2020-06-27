package com.shop.clothesmall.service;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.Admin.AdminRepository;
import com.shop.clothesmall.domain.Products.Product;
import com.shop.clothesmall.domain.Products.ProductCategoryDetail;
import com.shop.clothesmall.domain.Products.ProductCategoryDetailRepository;
import com.shop.clothesmall.domain.Products.ProductRepository;
import com.shop.clothesmall.domain.Products.dto.ProductCreateRequestDto;
import com.shop.clothesmall.domain.common.ResponseCheck;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductCategoryDetailRepository productCategoryDetailRepository;
    private final AdminRepository adminRepository;

    @Transactional
    public void create(ProductCreateRequestDto requestDto) {

        //Admin admin =

        Product newProduct = Product.builder()
                .name(requestDto.getName())
                .costPrice(requestDto.getCostPrice())
                .sellingPrice(requestDto.getSellingPrice())
                .productInformation(requestDto.getProductInformation())
                .status(requestDto.getStatus())
                .productCategoryDetailId()
                .adminId(admin)
                .isDeleted(1)
                .createdDate(LocalDateTime.now())
                .modifiedDate(LocalDateTime.now())
                .build();

        log.info("{}", newProduct);

        productRepository.save(newProduct);

//        productRepository.save();

//        return ResponseCheck.builder()
//                .code(200)
//                .message("OK")
//                .data()
//                .build();
    }

}
