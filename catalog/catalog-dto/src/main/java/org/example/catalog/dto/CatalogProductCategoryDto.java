package org.example.catalog.dto;

public record CatalogProductCategoryDto(
        CatalogProductCategoryId id,
        String title,
        String details,
        CatalogProductCategoryId parentId,
        Integer version) {
}
