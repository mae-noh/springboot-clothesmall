package com.shop.clothesmall.domain.Products.dto;

import com.shop.clothesmall.domain.Products.ProductCategory;
import com.shop.clothesmall.domain.Products.ProductCategoryDetail;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCategoryDetailRequestDto {

    private String name;
    private int priority;
    private ProductCategory productCategory;

    public ProductCategoryDetail toEntity(){
        return ProductCategoryDetail.builder()
                .name(name)
                .priority(priority)
                .productCategory(productCategory)
                .build();
    }

}
