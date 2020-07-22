package com.shop.clothesmall.domain.Products;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.BaseTimeEntity;
import com.shop.clothesmall.domain.Products.dto.status.isDeletedEnum;
import com.shop.clothesmall.domain.Products.dto.status.isStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;


//TODO : 요청응답값 맞추어서 할 것.
@Builder
@AllArgsConstructor
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

    @Enumerated(EnumType.STRING)
    private isStatusEnum status;

    @Enumerated(EnumType.STRING)
    private isDeletedEnum isDeleted;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_category_detail_id")
    private ProductCategoryDetail productCategoryDetail;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public void updateProduct(String name, String productInformation, int costPrice, int sellingPrice, isStatusEnum status, Admin admin, ProductCategoryDetail productCategoryDetail){
        this.name = name;
        this.productInformation = productInformation;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.status = status;
        this.admin = admin;
        this.productCategoryDetail = productCategoryDetail;
    }

    public void deleteProduct(){
        this.isDeleted = isDeletedEnum.Y;
    }
}
