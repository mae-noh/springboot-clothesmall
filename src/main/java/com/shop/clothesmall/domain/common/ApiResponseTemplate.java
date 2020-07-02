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

    public static <T> ApiResponseTemplate<T> ok(T data){
        return ApiResponseTemplate.<T>builder()
                .code(HttpStatus.OK.value())
                .message("OK")
                .data(data)
                .build();
    }

}
