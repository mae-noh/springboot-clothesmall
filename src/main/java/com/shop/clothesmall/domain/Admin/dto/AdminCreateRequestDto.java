package com.shop.clothesmall.domain.Admin.dto;

import com.shop.clothesmall.domain.Admin.Admin;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminCreateRequestDto {

    private String aid;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    private String status;

    private int isDeleted;

    //private LocalDateTime lastLoginDate;

    public Admin toEntity(){
        return Admin.builder()
                .aid(aid)
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .isDeleted(isDeleted)
                .status(status)
                .build();
    }

}
