package com.shop.clothesmall.service;

import com.shop.clothesmall.domain.Products.Product;
import com.shop.clothesmall.domain.Products.ProductRepository;
import com.shop.clothesmall.domain.Products.dto.page.PageResponseDto;
import com.shop.clothesmall.domain.Products.dto.productDtos.*;
import com.shop.clothesmall.domain.common.ApiResponseTemplate;
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

    public ApiResponseTemplate<ProductCreateResponseDto> create(ProductCreateRequestDto productCreateRequestDto){

        Product product = productCreateRequestDto.toEntity();
        productRepository.save(product);

        ProductCreateResponseDto productCreateResponseDto = product.toCreateProductResponseDto();

        return ApiResponseTemplate.ok(productCreateResponseDto);
    }

    public ApiResponseTemplate<ProductUpdateResponseDto> update(Long id, ProductUpdateRequestDto updateDto) {

        //TODO: exception 적절하게 처리
        Product product = productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 상품이 존재하지 않습니다. id :" + id));

        product.updateProduct(updateDto.getName(), updateDto.getCostPrice(), updateDto.getSellingPrice(), updateDto.getProductInformation(),
                updateDto.getStatus(), updateDto.getAdmin(), updateDto.getProductCategoryDetail());

        ProductUpdateResponseDto productUpdateResponseDto = product.toUpdateProductResponseDto();

        return ApiResponseTemplate.ok(productUpdateResponseDto);
    }

    public ApiResponseTemplate<ProductListResponseDto> list(Pageable pageable){

            int pageNumber = pageable.getPageNumber();
            int pageSize = pageable.getPageSize();

            pageable = PageRequest.of(pageNumber < 0 ? 0 : pageNumber, pageSize > 50 ? 50 : pageSize);

            Page<Product> products = productRepository.findAll(pageable);

            List<ProductListResponseDto> productListResponseDtoList = products.stream()
                     .map(Product::toListProductResponseDto).collect(Collectors.toList());

            PageResponseDto pageResponseDto = PageResponseDto.builder()
                    .totalPage(products.getTotalPages())
                    .totalElements(products.getTotalElements())
                    .curPage(products.getNumber())
                    .curElements(products.getNumberOfElements())
                    .build();

            return ApiResponseTemplate.ok(productListResponseDtoList, pageResponseDto);
        }

        public void delete(Long id){
            Product product = productRepository.findById(id).orElseThrow(()->new IllegalArgumentException("해당 게시글이 존재하지 않는다. id : " + id));
            productRepository.delete(product);
        }

}
