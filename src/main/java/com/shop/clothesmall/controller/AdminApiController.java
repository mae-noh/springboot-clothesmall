package com.shop.clothesmall.controller;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.Admin.AdminRepository;
import com.shop.clothesmall.domain.Admin.dto.AdminCreateRequestDto;
import com.shop.clothesmall.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AdminApiController {

    private final AdminService adminService;

    @PostMapping("/api/admins")
    public String create(@RequestBody AdminCreateRequestDto adminCreateRequestDto){
        adminService.create(adminCreateRequestDto);
        return "OK";
    }

}
