package org.example.catalog.dto;

public record ProductCategoryDto(
        ProductCategoryId id,
        String title,
        String details,
        ProductCategoryId parentId,
        Integer version) {
}
