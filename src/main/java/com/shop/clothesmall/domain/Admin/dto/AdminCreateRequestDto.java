package com.shop.clothesmall.domain.Admin.dto;

import com.shop.clothesmall.domain.Admin.Admin;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class AdminCreateRequestDto {

    private String aid;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    private String status;

    private LocalDateTime lastLoginDate;

    public Admin toEntity(){
        return Admin.builder()
                .aid(aid)
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .status(status)
                .build();
    }

}
