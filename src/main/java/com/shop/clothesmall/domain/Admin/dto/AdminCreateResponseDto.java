package com.shop.clothesmall.domain.Admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
public class AdminCreateResponseDto {
    private String aid;
    private String password;
    private String name;
    private String email;
    private String phoneNumber;
    private String status;
    //private LocalDateTime lastLoginDate;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
