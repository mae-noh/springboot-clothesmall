package com.shop.clothesmall.service;

import com.shop.clothesmall.domain.Products.Product;
import com.shop.clothesmall.domain.Products.ProductRepository;
import com.shop.clothesmall.domain.Products.dto.productDtos.PageResponseDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductCreateRequestDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductListResponseDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.ProductUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Transactional
@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void create(ProductCreateRequestDto productCreateRequestDto){
        productRepository.save(productCreateRequestDto.toEntity());
    }

    public void update(Long id, ProductUpdateRequestDto updateDto) {
        Product product = productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 상품이 존재하지 않습니다. id :" + id));

        product.updateProduct(updateDto.getName(), updateDto.getCostPrice(), updateDto.getSellingPrice(), updateDto.getProductInformation(),
                updateDto.getStatus(), updateDto.getAdmin(), updateDto.getProductCategoryDetail());

//        this.name = name;
//        this.costPrice = costPrice;
//        this.sellingPrice = sellingPrice;
//        this.productInformation = productInformation;
//        this.status = status;
//        this.admin = admin;
//        this.productCategoryDetail = productCategoryDetail;
    }

    public PageResponseDto list(Pageable pageable){
            int pageNumber = pageable.getPageNumber();
            int pageSize = pageable.getPageSize();

            pageable = PageRequest.of(pageNumber < 0 ? 0 : pageNumber, pageSize > 50 ? 50 : pageSize);

            Page<Product> products = productRepository.findAll(pageable);

            List<ProductListResponseDto> productListResponseDtoList = products.stream()
                    .map(this::response)
                    .collect(Collectors.toList());

            PageResponseDto pageResponseDto = PageResponseDto.builder()
                    .productList(productListResponseDtoList)
                    .totalPage(products.getTotalPages())
                    .totalElements(products.getTotalElements())
                    .curPage(products.getNumber())
                    .curElements(products.getNumberOfElements())
                    .build();

            return pageResponseDto;
        }

        public ProductListResponseDto response(Product product){
            return ProductListResponseDto.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .costPrice(product.getCostPrice())
                    .sellingPrice(product.getSellingPrice())
                    .isDeleted(product.getIsDeleted())
                    .status(product.getStatus())
                    .adminId(product.getAdmin().getId())
                    .adminName(product.getAdmin().getName())
                    .productCategoryName(product.getProductCategoryDetail().getProductCategory().getName())
                    .productCategoryDetailName(product.getProductCategoryDetail().getName())
                    .build();

        }
}
