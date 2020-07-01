package com.shop.clothesmall.service;

import com.shop.clothesmall.domain.Products.Product;
import com.shop.clothesmall.domain.Products.ProductRepository;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductCreateRequestDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void create(ProductCreateRequestDto productCreateRequestDto){
        productRepository.save(productCreateRequestDto.toEntity());
    }

    public void update(Long id, ProductUpdateRequestDto updateDto) {
        Product product = productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 상품이 존재하지 않습니다. id :" + id));

        product.updateProduct(updateDto.getName(), updateDto.getCostPrice(), updateDto.getSellingPrice(), updateDto.getProductInformation(),
                updateDto.getStatus(), updateDto.getAdmin(), updateDto.getProductCategoryDetail());

//        this.name = name;
//        this.costPrice = costPrice;
//        this.sellingPrice = sellingPrice;
//        this.productInformation = productInformation;
//        this.status = status;
//        this.admin = admin;
//        this.productCategoryDetail = productCategoryDetail;
    }


}
