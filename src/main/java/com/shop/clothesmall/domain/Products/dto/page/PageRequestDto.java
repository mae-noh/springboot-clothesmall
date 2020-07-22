package com.shop.clothesmall.domain.Products.dto.page;

import com.shop.clothesmall.domain.Products.dto.status.isDeletedEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Size;

@Builder
@Getter
@AllArgsConstructor
public class PageRequestDto {
    private int page;
    @Size(max = 20)
    private int size;
    private isDeletedEnum isDeleted;
}
