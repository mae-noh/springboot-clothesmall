package com.shop.clothesmall.domain.common;

import lombok.*;
import org.springframework.http.HttpStatus;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseTemplate <T>{

    private int code;
    private String message;
    private T data;


    public static ApiResponseTemplate ok(){
        return ApiResponseTemplate.builder()
                .code(HttpStatus.OK.value())
                .message("OK")
                .build();
    }

    public static <T> ApiResponseTemplate<T> ok(T data){
        return (ApiResponseTemplate<T>)ApiResponseTemplate.builder()
                .code(HttpStatus.OK.value())
                .message("OK")
                .data(data)
                .build();
    }

}
