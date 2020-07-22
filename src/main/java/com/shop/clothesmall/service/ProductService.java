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

    //TODO : github에 올리기
    private final ProductRepository productRepository;
    private final AdminRepository adminRepository;
    private final ProductCategoryDetailRepository productCategoryDetailRepository;

    public ProductCreateResponseDto create(ProductCreateRequestDto productCreateRequestDto){

        Long adminId = productCreateRequestDto.getAdminId();
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(()->new BusinessException("해당 관리자를 찾을 수 없습니다. id :" + adminId));

        Long categoryDetailId = productCreateRequestDto.getCategoryDetailId();
        ProductCategoryDetail productCategoryDetail = productCategoryDetailRepository.findById(categoryDetailId)
                .orElseThrow(()->new BusinessException("해당 카테고리 상세를 찾을 수 없습니다. id :" + categoryDetailId));

        Product product = productCreateRequestDto.toEntity(admin, productCategoryDetail);
        Product saveProduct = productRepository.save(product);
        ProductCreateResponseDto productCreateResponseDto = toCreateProductResponseDto(saveProduct);

        return productCreateResponseDto;
    }

    public ProductUpdateResponseDto update(Long id, ProductUpdateRequestDto updateDto) {

        Product product = productRepository.findById(id).orElseThrow(()->new BusinessException("해당 상품을 찾을 수 없습니다. id :" + id));

        Long adminId = updateDto.getAdminId();
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(()->new BusinessException("해당 관리자를 찾을 수 없습니다. id :" + adminId));

        Long categoryDetailId = updateDto.getCategoryDetailId();
        ProductCategoryDetail productCategoryDetail = productCategoryDetailRepository.findById(categoryDetailId)
                .orElseThrow(()->new BusinessException("해당 카테고리 상세를 찾을 수 없습니다. id :" + categoryDetailId));

        product.updateProduct(updateDto.getName(), updateDto.getProductInformation(), updateDto.getCostPrice(), updateDto.getSellingPrice(),
                updateDto.getStatus(), admin, productCategoryDetail);

        ProductUpdateResponseDto productUpdateResponseDto = toUpdateProductResponseDto(product);

        return productUpdateResponseDto;
    }

    @Transactional(readOnly = true)
    public PageResponseDto list(PageRequestDto pageRequestDto){

            Pageable pageable = PageRequest.of(pageRequestDto.getPage(), pageRequestDto.getSize());

            Page<Product> products = productRepository.findAll(pageable);

            List<ProductListResponseDto> productListResponseDtoList = products.stream()
                     .map(this::toListProductResponseDto).collect(Collectors.toList());

            PageResponseDto pageResponseDto = PageResponseDto.builder()
                    .page(pageable.getPageNumber())
                    .size(pageable.getPageSize())
                    .totalCount(products.getTotalElements())
                    .list(productListResponseDtoList)
                    .build();

            return pageResponseDto;
        }

        public void delete(Long id){
            Product product = productRepository.findById(id).orElseThrow(()->new BusinessException("해당 게시글이 존재하지 않습니다. id :" + id));

            product.deleteProduct();
        }

    public ProductCreateResponseDto toCreateProductResponseDto(Product product){
        return ProductCreateResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .costPrice(product.getCostPrice())
                .category(product.getProductCategoryDetail().getProductCategory().getName())
                .categoryDetail(product.getProductCategoryDetail().getName())
                .sellingPrice(product.getSellingPrice())
                .productInformation(product.getProductInformation())
                .adminId(product.getAdmin().getId())
                .adminName(product.getAdmin().getName())
                .isDeleted(product.getIsDeleted())
                .status(product.getStatus())
                .createdDate(product.getCreatedDate())
                .modifiedDate(product.getModifiedDate())
                .build();
    }

    public ProductUpdateResponseDto toUpdateProductResponseDto(Product product){
        return ProductUpdateResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .costPrice(product.getCostPrice())
                .sellingPrice(product.getSellingPrice())
                .productInformation(product.getProductInformation())
                .category(product.getProductCategoryDetail().getProductCategory().getName())
                .categoryDetail(product.getProductCategoryDetail().getName())
                .adminId(product.getAdmin().getId())
                .adminName(product.getAdmin().getName())
                .isDeleted(product.getIsDeleted())
                .status(product.getStatus())
                .modifiedDate(product.getModifiedDate())
                .createdDate(product.getCreatedDate())
                .build();
    }

    public ProductListResponseDto toListProductResponseDto(Product product){
        return ProductListResponseDto.builder()
                .id(product.getId())
                .name(product.getName())
                .costPrice(product.getCostPrice())
                .category(product.getProductCategoryDetail().getProductCategory().getName())
                .categoryDetail(product.getProductCategoryDetail().getName())
                .sellingPrice(product.getSellingPrice())
                .adminId(product.getAdmin().getId())
                .adminName(product.getAdmin().getName())
                .status(product.getStatus())
                .isDeleted(product.getIsDeleted())
                .modifiedDate(product.getModifiedDate())
                .createdDate(product.getCreatedDate())
                .build();
    }
}
