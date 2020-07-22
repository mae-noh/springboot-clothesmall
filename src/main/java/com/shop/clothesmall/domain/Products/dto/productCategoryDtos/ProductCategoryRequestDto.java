package com.shop.clothesmall.domain.Products.dto.productCategoryDtos;

import com.shop.clothesmall.domain.Products.ProductCategory;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductCategoryRequestDto {

    private String name;
    private int priority;

    public ProductCategory toEntity(){
        return ProductCategory.builder()
                .name(name)
                .priority(priority)
                .build();
    }

}
