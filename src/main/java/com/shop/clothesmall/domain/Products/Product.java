package com.shop.clothesmall.domain.Products;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.BaseTimeEntity;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductCreateResponseDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductListResponseDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductUpdateResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;


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

    private String status;

    private int isDeleted;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_category_detail_id")
    private ProductCategoryDetail productCategoryDetail;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "admin_id")
    private Admin admin;

    public ProductCreateResponseDto toCreateProductResponseDto(){
        return ProductCreateResponseDto.builder()
                .id(id)
                .name(name)
                .costPrice(costPrice)
                .sellingPrice(sellingPrice)
                .productInformation(productInformation)
                .categoryName(productCategoryDetail.getProductCategory().getName())
                .categoryDetailName(productCategoryDetail.getName())
                .adminId(admin.getId())
                .adminName(admin.getName())
                .isDeleted(isDeleted)
                .status(status)
                .modifiedDate(getModifiedDate())
                .createdDate(getCreatedDate())
                .build();
    }

    public void updateProduct(String name, int costPrice, int sellingPrice, String productInformation, String status, Admin admin, ProductCategoryDetail productCategoryDetail){
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productInformation = productInformation;
        this.status = status;
        this.admin = admin;
        this.productCategoryDetail = productCategoryDetail;
    }

    public ProductUpdateResponseDto toUpdateProductResponseDto(){
        return ProductUpdateResponseDto.builder()
                .id(id)
                .name(name)
                .costPrice(costPrice)
                .sellingPrice(sellingPrice)
                .productInformation(productInformation)
                .status(status)
                .isDeleted(isDeleted)
                .categoryName(productCategoryDetail.getProductCategory().getName())
                .categoryDetailName(productCategoryDetail.getName())
                .adminId(admin.getId())
                .adminName(admin.getName())
                .modifiedDate(getModifiedDate())
                .createdDate(getCreatedDate())
                .build();
    }

    public ProductListResponseDto toListProductResponseDto(){
        return ProductListResponseDto.builder()
                .id(id)
                .name(name)
                .costPrice(costPrice)
                .sellingPrice(sellingPrice)
                .productInformation(productInformation)
                .status(status)
                .isDeleted(isDeleted)
                .categoryName(productCategoryDetail.getProductCategory().getName())
                .categoryDetailName(productCategoryDetail.getName())
                .adminId(admin.getId())
                .adminName(admin.getName())
                .modifiedDate(getModifiedDate())
                .createdDate(getCreatedDate())
                .build();
    }

}
