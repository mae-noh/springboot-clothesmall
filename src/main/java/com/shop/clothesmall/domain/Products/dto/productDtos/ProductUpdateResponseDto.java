package com.shop.clothesmall.domain.Products.dto.productDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductUpdateResponseDto {

    private Long id;
    private String name;
    private Integer costPrice;
    private Integer sellingPrice;
    private String productInformation;
    private String status;
    private Integer isDeleted;
    private String categoryName;
    private String categoryDetailName;
    private Long adminId;
    private String adminName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modifiedDate;

}
