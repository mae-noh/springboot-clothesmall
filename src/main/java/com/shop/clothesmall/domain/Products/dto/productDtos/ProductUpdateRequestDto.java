package com.shop.clothesmall.domain.Products.dto.productDtos;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.Products.ProductCategoryDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateRequestDto {

    private Long id;
    private String name;
    private int costPrice;
    private int sellingPrice;
    private String productInformation;
    private String status;

    private Admin admin;
    private ProductCategoryDetail productCategoryDetail;

}
