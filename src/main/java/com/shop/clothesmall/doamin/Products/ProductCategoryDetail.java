package com.shop.clothesmall.doamin.Products;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Table(name = "product_category_detail")
@Entity
public class ProductCategoryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer priority;

    private Integer isDeleted;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategoryId;

}
