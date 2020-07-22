package com.shop.clothesmall.domain.Products;

import com.shop.clothesmall.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Table(name = "product_category")
@Entity
public class ProductCategory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    private int priority;

    @Column(nullable = true)
    private int isDeleted;

    @Builder
    public ProductCategory(String name, int priority){
        this.name = name;
        this.priority = priority;
    }
}
