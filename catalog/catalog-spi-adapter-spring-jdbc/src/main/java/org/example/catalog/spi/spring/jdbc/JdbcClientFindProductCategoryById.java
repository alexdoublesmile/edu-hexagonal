package org.example.catalog.spi.spring.jdbc;

import org.example.catalog.dto.ProductCategoryDto;
import org.example.catalog.dto.ProductCategoryId;
import org.example.catalog.spi.FindProductCategoryByIdSpi;

import java.util.Optional;

public class JdbcClientFindProductCategoryById implements FindProductCategoryByIdSpi {
    @Override
    public Optional<ProductCategoryDto> findProductCategoryById(ProductCategoryId id) {
        return Optional.empty();
    }
}
