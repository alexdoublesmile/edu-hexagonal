package org.example.catalog.api;

import org.example.catalog.dto.ProductCategoryDto;
import org.example.catalog.dto.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryApi {
    Optional<ProductCategoryDto> findProductCategory(ProductCategoryId id);
}
