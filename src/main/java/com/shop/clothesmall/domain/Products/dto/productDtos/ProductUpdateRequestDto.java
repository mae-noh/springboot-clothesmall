package com.shop.clothesmall.domain.Products.dto.productDtos;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.Products.ProductCategoryDetail;
import com.shop.clothesmall.domain.Products.dto.status.isStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateRequestDto {

    private String name;
    private String productInformation;
    private int costPrice;
    private int sellingPrice;
    private isStatusEnum status;
    private Long adminId;
    private Long categoryDetailId;

    private Admin admin;
    private ProductCategoryDetail productCategoryDetail;

}
