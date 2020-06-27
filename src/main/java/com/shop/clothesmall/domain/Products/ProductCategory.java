package com.shop.clothesmall.domain.Products;

import com.shop.clothesmall.domain.BaseTimeEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_category")
@Entity
public class ProductCategory extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer priority;

    private Integer isDeleted;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

}
