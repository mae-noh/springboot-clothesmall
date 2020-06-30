package com.shop.clothesmall.domain.Admin;

import com.shop.clothesmall.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Data
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

    @Column(nullable = true)
    private int isDeleted;

    @Column(nullable = true)
    private LocalDateTime lastLoginDate;

    private String status;

    @Builder
    public Admin(String aid, String name, String email, String password, String phoneNumber, String status) {
        this.aid = aid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
    }

}
