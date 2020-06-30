package com.shop.clothesmall.domain.Products.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponseDto {

    private Long id;
    private String name;
    private Integer costPrice;
    private String category;
    private String categoryDetail;
    private Integer sellingPrice;
    private String productInformation;
    private String status;
    private Integer isDeleted;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    private Long adminId;
    private String adminName;

}
