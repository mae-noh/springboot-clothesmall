package com.shop.clothesmall.domain.Products.dto;

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
    private Integer costPrice;
    private Integer sellingPrice;
    private String productInformation;
    private String status;

    private Long categoryDetail;
    private Long category;

}
