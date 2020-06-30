package com.shop.clothesmall.service;

import com.shop.clothesmall.domain.Admin.AdminRepository;
import com.shop.clothesmall.domain.Admin.dto.AdminCreateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public void create(AdminCreateRequestDto adminCreateRequestDto){
        adminRepository.save(adminCreateRequestDto.toEntity());
    }

}
