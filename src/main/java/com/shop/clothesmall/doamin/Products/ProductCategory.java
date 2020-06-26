package com.shop.clothesmall.doamin.Products;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "product_category")
@Entity
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer priority;

    private Integer isDeleted;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

}
