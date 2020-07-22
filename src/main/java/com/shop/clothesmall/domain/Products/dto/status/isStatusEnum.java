package com.shop.clothesmall.domain.Products.dto.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum isStatusEnum {
    SALE("판매중"),
    STOP("판매정지");

    private String desc;
}
