package com.shop.clothesmall.domain.common;

import com.shop.clothesmall.domain.Products.dto.productDtos.ProductCreateResponseDto;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCheck {

    private int code;
    private String message;

    private ProductCreateResponseDto data;

}
