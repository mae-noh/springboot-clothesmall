package com.shop.clothesmall.domain.Products.dto.productDtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.shop.clothesmall.domain.Products.dto.status.isDeletedEnum;
import com.shop.clothesmall.domain.Products.dto.status.isStatusEnum;
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
    private String category;
    private String categoryDetail;
    private Integer sellingPrice;
    private String productInformation;
    private Long adminId;
    private String adminName;
    private isStatusEnum status;
    private isDeletedEnum isDeleted;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime createdDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime modifiedDate;

}

