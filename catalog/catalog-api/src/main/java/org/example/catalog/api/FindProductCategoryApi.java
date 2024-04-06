package org.example.catalog.api;

import org.example.catalog.dto.CatalogProductCategoryDto;
import org.example.catalog.dto.CatalogProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryApi {
    Optional<CatalogProductCategoryDto> findProductCategory(CatalogProductCategoryId id);
}
