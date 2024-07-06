package com.dev.mapper;

import com.dev.dto.ProductDTO;
import com.dev.entity.Product;

public class ProductMapper {

    public static ProductDTO fromProductToProductDTO(Product product) {
        return ProductDTO.builder()
                .name(product.getName())
                .description(product.getDescription())
                .category(product.getCategory())
                .model(product.getModel())
                .price(product.getPrice())
                .build();
    }

    public static Product fromProductDTOToProduct(ProductDTO dto) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .category(dto.getCategory())
                .model(dto.getModel())
                .price(dto.getPrice())
                .build();
    }

}
