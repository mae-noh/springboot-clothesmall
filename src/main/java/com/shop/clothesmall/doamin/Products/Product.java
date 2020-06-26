package com.shop.clothesmall.doamin.Products;

import com.shop.clothesmall.doamin.Admin.Admin;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Data
@Table(name = "product")
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer costPrice;

    private Integer sellingPrice;

    private String productInformation;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private String status;

    private Integer isDeleted;

    @ManyToOne
    @JoinColumn(name = "product_category_detail_id")
    private ProductCategoryDetail productCategoryDetailId;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin adminId;

}
