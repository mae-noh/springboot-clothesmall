package com.shop.clothesmall.domain.Products;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryDetailRepositoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Autowired
    private ProductCategoryDetailRepository productCategoryDetailRepository;

    @Test
    public void save_category(){
        //given
        ProductCategory productCategory = productCategoryRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("no item"));


        String name = "긴팔";
        ProductCategoryDetail productCategoryDetail = ProductCategoryDetail.builder()
                .id(1L)
                .name(name)
                .priority(1)
                .productCategory(productCategory)
                .build();

        // when
        productCategoryDetailRepository.save(productCategoryDetail);

        ProductCategoryDetail saveProductCategoryDetail = productCategoryDetailRepository.findById(1L).orElseThrow(() -> new IllegalArgumentException("not found exception"));

        // then

        assertThat(saveProductCategoryDetail.getName()).isEqualTo(name);

    }

//    @Test
//    public void findByIdCheck(){
//
//        //given
//        ProductCategory productCategory = ProductCategory.builder()
//                .id(1L)
//                .name("상의")
//                .priority(1)
//                .build();
//
//        ProductCategoryDetail productCategoryDetail = ProductCategoryDetail.builder()
//                .id(1L)
//                .name("긴팔")
//                .priority(1)
//                .productCategory(productCategory)
//                .build();
//
//        // when
//        ProductCategoryDetail productCategoryDetail1 = productCategoryDetailRepository.findById(1L).orElseGet(ProductCategoryDetail::new);
//
//        // then
//        assertThat(productCategoryDetail.getId()).isEqualTo(productCategoryDetail1.getId());
//    }

}