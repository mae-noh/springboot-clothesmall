package com.shop.clothesmall.doamin.Products;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {

    //Dependency Injection
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void create(){

        //given
        Product product = new Product();

        product.setName("상품명");
        product.setCostPrice(500);
        product.setSellingPrice(1000);
        product.setProductInformation("상품상세설명");
        product.setCreatedDate(LocalDateTime.now());

        //when
        Product products = productRepository.save(product);

        //then
        System.out.println(products);

    }

}