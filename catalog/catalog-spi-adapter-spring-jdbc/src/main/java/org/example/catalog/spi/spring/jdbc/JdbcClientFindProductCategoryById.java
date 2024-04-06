package org.example.catalog.spi.spring.jdbc;

import org.example.catalog.dto.CatalogProductCategoryDto;
import org.example.catalog.dto.CatalogProductCategoryId;
import org.example.catalog.spi.FindProductCategoryByIdSpi;

import java.util.Optional;

public class JdbcClientFindProductCategoryById implements FindProductCategoryByIdSpi {
    @Override
    public Optional<CatalogProductCategoryDto> findProductCategoryById(CatalogProductCategoryId id) {
        return Optional.empty();
    }
}
