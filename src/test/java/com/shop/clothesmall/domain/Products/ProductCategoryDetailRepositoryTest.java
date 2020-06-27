package com.shop.clothesmall.domain.Products;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@ActiveProfiles("local")
public class ProductCategoryDetailRepositoryTest {

    @Autowired(required = true)
    ProductCategoryDetailRepository productCategoryDetailRepository;

    @Test
    public void findByIdCheck(){

        //given
        ProductCategory productCategory = ProductCategory.builder()
                .id(1L)
                .name("상의")
                .priority(1)
                .isDeleted(1)
                .build();

        ProductCategoryDetail productCategoryDetail = ProductCategoryDetail.builder()
                .id(1L)
                .name("긴팔")
                .priority(1)
                .isDeleted(1)
                .productCategory(productCategory)
                .build();

        // when
        ProductCategoryDetail productCategoryDetail1 = productCategoryDetailRepository.findById(1L).orElseGet(ProductCategoryDetail::new);

        // then
        assertThat(productCategoryDetail.getId()).isEqualTo(productCategoryDetail1.getId());
    }

}