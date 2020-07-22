package com.shop.clothesmall.domain.Products.dto.page;

import com.shop.clothesmall.domain.Products.dto.productDtos.ProductListResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponseDto {

    private int page;
    private int size;
    private Long totalCount;
    private List<ProductListResponseDto> list;

//    private int totalPage;
//    private Long totalElements;
//    private int curPage;
//    private int curElements;

}
