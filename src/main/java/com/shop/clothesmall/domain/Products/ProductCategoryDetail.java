package com.shop.clothesmall.domain.Products;

import com.shop.clothesmall.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "product_category_detail")
@Entity
public class ProductCategoryDetail extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer priority;

    private Integer isDeleted;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

}
