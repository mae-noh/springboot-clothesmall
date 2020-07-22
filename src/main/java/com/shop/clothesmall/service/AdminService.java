package com.shop.clothesmall.service;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.Admin.AdminRepository;
import com.shop.clothesmall.domain.Admin.dto.AdminCreateRequestDto;
import com.shop.clothesmall.domain.Admin.dto.AdminCreateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public void createAdmin(AdminCreateRequestDto adminCreateRequestDto){
        adminRepository.save(adminCreateRequestDto.toEntity());
    }

    public AdminCreateResponseDto createAdminResponseDto(Admin admin){
        return AdminCreateResponseDto.builder()
                .aid(admin.getAid())
                .password(admin.getPassword())
                .name(admin.getName())
                .email(admin.getEmail())
                .phoneNumber(admin.getPhoneNumber())
                .status(admin.getStatus())
                .createdDate(admin.getCreatedDate())
                .modifiedDate(admin.getModifiedDate())
                .build();
    }

}
