package org.example.catalog.spi;

import org.example.catalog.dto.ProductCategoryDto;
import org.example.catalog.dto.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryByIdSpi {
    Optional<ProductCategoryDto> findProductCategoryById(ProductCategoryId id);
}
