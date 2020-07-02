package com.shop.clothesmall.domain.Products.dto.productDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shop.clothesmall.domain.Products.Product;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductCreateResponseDto {

    private Long id;
    private String name;
    private Integer costPrice;
    private String categoryName;
    private String categoryDetailName;
    private Integer sellingPrice;
    private String productInformation;
    private String status;
    private Integer isDeleted;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modifiedDate;
    private Long adminId;
    private String adminName;

}

