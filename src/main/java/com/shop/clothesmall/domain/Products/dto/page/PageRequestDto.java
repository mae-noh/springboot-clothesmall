package com.shop.clothesmall.domain.Products.dto.page;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;

@Getter
@NoArgsConstructor
public class PageRequestDto {
    private int pageNumber;
    @Size(max = 20)
    private int pageSize;
}
