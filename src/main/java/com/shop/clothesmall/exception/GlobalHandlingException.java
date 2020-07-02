package com.shop.clothesmall.exception;

import com.shop.clothesmall.domain.common.ApiResponseTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlingException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseTemplate methodArgumentNotValidException(MethodArgumentNotValidException ex) {

        ApiResponseTemplate apiResponseTemplate = ApiResponseTemplate.builder()
                .code(400)
                .message(ex.getMessage())
                .build();

        return apiResponseTemplate;
    }

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public ApiResponseTemplate BusinessException(BusinessException ex) {

        ApiResponseTemplate apiResponseTemplate = ApiResponseTemplate.builder()
                .code(400)
                .message(ex.getMessage())
                .build();

        return apiResponseTemplate;
    }

}
