package com.shop.clothesmall.domain.Products.dto.status;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum isDeletedEnum {
    N(0),
    Y(1);

    private int code;
}
