package com.shop.clothesmall.domain.common;

import com.shop.clothesmall.domain.Products.dto.page.PageResponseDto;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseTemplate <T>{

    private int code;
    private String message;
    private T data;
    private List<T> dataList;
    private PageResponseDto page;

    public static <T> ApiResponseTemplate<T> ok(T data){
        return ApiResponseTemplate.<T>builder()
                .code(HttpStatus.OK.value())
                .message("OK")
                .data(data)
                .build();
    }

    public static <T> ApiResponseTemplate<T> ok(List<T> dataList, PageResponseDto page){
        return ApiResponseTemplate.<T>builder()
                .code(HttpStatus.OK.value())
                .message("OK")
                .dataList(dataList)
                .page(page)
                .build();
    }
}
