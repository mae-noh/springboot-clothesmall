package com.shop.clothesmall.domain.Admin;

import com.shop.clothesmall.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "admin")
@Entity
public class Admin extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aid;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    private int isDeleted;

//    @Column(nullable = true)
//    private LocalDateTime lastLoginDate;

    private String status;

}
