package com.shop.clothesmall.doamin.Admin;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "admin")
@Entity
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aid;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    private Integer isDeleted;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private LocalDateTime lastLoginDate;

    private String status;

}
