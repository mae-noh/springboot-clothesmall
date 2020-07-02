package com.shop.clothesmall.domain.Products.dto.productDtos;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.Products.Product;
import com.shop.clothesmall.domain.Products.ProductCategoryDetail;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateRequestDto {

    private Long id;
    private String name;
    private int costPrice;
    private int sellingPrice;
    private String productInformation;
    private String status;

    private Admin admin;
    private ProductCategoryDetail productCategoryDetail;

    public Product toEntity(Admin admin, ProductCategoryDetail productCategoryDetail) {
        return Product.builder()
                .name(name)
                .productInformation(productInformation)
                .costPrice(costPrice)
                .sellingPrice(sellingPrice)
                .status(status)
                .admin(admin)
                .productCategoryDetail(productCategoryDetail)
                .build();
    }
}
