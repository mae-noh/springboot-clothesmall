package com.shop.clothesmall.domain.Products;

import com.shop.clothesmall.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@Table(name = "product_category_detail")
@Entity
public class ProductCategoryDetail extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(nullable = true)
    private int priority;

    @Column(nullable = true)
    private int isDeleted;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @Builder
    public ProductCategoryDetail(String name, int priority, ProductCategory productCategory){
        this.name = name;
        this.priority = priority;
        this.productCategory = productCategory;
    }

}
