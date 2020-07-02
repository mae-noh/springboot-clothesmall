package com.shop.clothesmall.service;

import com.shop.clothesmall.domain.Admin.Admin;
import com.shop.clothesmall.domain.Admin.AdminRepository;
import com.shop.clothesmall.domain.Products.Product;
import com.shop.clothesmall.domain.Products.ProductCategoryDetail;
import com.shop.clothesmall.domain.Products.ProductCategoryDetailRepository;
import com.shop.clothesmall.domain.Products.ProductRepository;
import com.shop.clothesmall.domain.Products.dto.page.PageRequestDto;
import com.shop.clothesmall.domain.Products.dto.page.PageResponseDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.*;
import com.shop.clothesmall.exception.BusinessException;
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
    private final AdminRepository adminRepository;
    private final ProductCategoryDetailRepository productCategoryDetailRepository;

    public ProductCreateResponseDto create(ProductCreateRequestDto productCreateRequestDto){

        Long adminId = productCreateRequestDto.getAdmin().getId();
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(()->new BusinessException("해당 관리자를 찾을 수 없습니다. id :" + adminId));

        Long categoryDetailId = productCreateRequestDto.getProductCategoryDetail().getId();
        ProductCategoryDetail productCategoryDetail = productCategoryDetailRepository.findById(categoryDetailId)
                .orElseThrow(()->new BusinessException("해당 카테고리 상세를 찾을 수 없습니다. id :" + categoryDetailId));

        Product product = productCreateRequestDto.toEntity(admin, productCategoryDetail);
        productRepository.save(product);

        ProductCreateResponseDto productCreateResponseDto = product.toCreateProductResponseDto();

        return productCreateResponseDto;
    }

    public ProductUpdateResponseDto update(Long id, ProductUpdateRequestDto updateDto) {

        Product product = productRepository.findById(id).orElseThrow(()->new BusinessException("해당 상품을 찾을 수 없습니다. id :" + id));

        product.updateProduct(updateDto.getName(), updateDto.getCostPrice(), updateDto.getSellingPrice(), updateDto.getProductInformation(),
                updateDto.getStatus(), updateDto.getAdmin(), updateDto.getProductCategoryDetail());

        ProductUpdateResponseDto productUpdateResponseDto = product.toUpdateProductResponseDto();

        return productUpdateResponseDto;
    }

    @Transactional(readOnly = true)
    public PageResponseDto list(PageRequestDto pageRequestDto){

            Pageable pageable = PageRequest.of(pageRequestDto.getPageNumber(), pageRequestDto.getPageSize());

            Page<Product> products = productRepository.findAll(pageable);

            List<ProductListResponseDto> productListResponseDtoList = products.stream()
                     .map(Product::toListProductResponseDto).collect(Collectors.toList());

            PageResponseDto pageResponseDto = PageResponseDto.builder()
                    .productListResponseDtoList(productListResponseDtoList)
                    .totalPage(products.getTotalPages())
                    .totalElements(products.getTotalElements())
                    .curPage(products.getNumber())
                    .curElements(products.getNumberOfElements())
                    .build();

            return pageResponseDto;
        }

        public void delete(Long id){
            Product product = productRepository.findById(id).orElseThrow(()->new BusinessException("해당 게시글이 존재하지 않습니다. id :" + id));
            productRepository.delete(product);
        }

}
