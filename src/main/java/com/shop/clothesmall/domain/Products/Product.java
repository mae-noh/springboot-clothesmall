package com.shop.clothesmall.domain.Products;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Builder
@NoArgsConstructor
@Getter
@Table(name = "product")
@Entity
public class Product extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer costPrice;

    private Integer sellingPrice;

    private String productInformation;

    private String status;

    private Integer isDeleted;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_category_detail_id")
    private ProductCategoryDetail productCategoryDetail;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

//    public static Product createProduct(ProductCategoryDetail productCategoryDetailId, Admin adminId) {
//        Product product = new Product();
//        product.setProductCategoryDetailId(productCategoryDetailId);
//        product.setAdminId(adminId);
//        product.setCreatedDate(LocalDateTime.now());
//        product.setModifiedDate(LocalDateTime.now());
//        return product;
//    }

}
