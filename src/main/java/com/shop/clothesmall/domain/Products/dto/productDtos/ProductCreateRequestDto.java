package com.shop.clothesmall.domain.Products.dto.productDtos;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.Products.Product;
import com.shop.clothesmall.domain.Products.ProductCategoryDetail;
import com.shop.clothesmall.domain.Products.dto.status.isDeletedEnum;
import com.shop.clothesmall.domain.Products.dto.status.isStatusEnum;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateRequestDto {

    private String name;
    private String productInformation;
    private int costPrice;
    private int sellingPrice;
    private isStatusEnum status;
    private isDeletedEnum isDeleted;
    private Long adminId;
    private Long categoryDetailId;

    private Admin admin;
    private ProductCategoryDetail productCategoryDetail;

    public Product toEntity(Admin admin, ProductCategoryDetail productCategoryDetail) {
        return Product.builder()
                .name(name)
                .productInformation(productInformation)
                .costPrice(costPrice)
                .sellingPrice(sellingPrice)
                .status(status)
                .isDeleted(isDeletedEnum.N)
                .admin(admin)
                .productCategoryDetail(productCategoryDetail)
                .build();
    }
}
