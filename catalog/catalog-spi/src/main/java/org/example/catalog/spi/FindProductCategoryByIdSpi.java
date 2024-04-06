package org.example.catalog.spi;

import org.example.catalog.dto.CatalogProductCategoryDto;
import org.example.catalog.dto.CatalogProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryByIdSpi {
    Optional<CatalogProductCategoryDto> findProductCategoryById(CatalogProductCategoryId id);
}
