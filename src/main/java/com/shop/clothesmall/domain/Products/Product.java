package com.shop.clothesmall.domain.Products;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@NoArgsConstructor
@Getter
@Table(name = "product")
@Entity
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int costPrice;

    private int sellingPrice;

    private String productInformation;

    private String status;

    private int isDeleted;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_category_detail_id")
    private ProductCategoryDetail productCategoryDetail;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @Builder
    public Product(String name, int costPrice, int sellingPrice, String productInformation, String status, ProductCategoryDetail productCategoryDetail, Admin admin){
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productInformation = productInformation;
        this.status = status;
        this.admin = admin;
        this.productCategoryDetail = productCategoryDetail;
    }

}
