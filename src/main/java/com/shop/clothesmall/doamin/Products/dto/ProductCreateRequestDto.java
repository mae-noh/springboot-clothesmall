package com.shop.clothesmall.doamin.Products.dto;

import com.shop.clothesmall.doamin.Products.Product;
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

    private void toEntity() {
    }
}
