package org.example.catalog.data;

import org.example.catalog.id.ProductCategoryId;

public record ProductCategoryData(
        ProductCategoryId id,
        String title,
        String details,
        ProductCategoryId parentId,
        Integer version) {
}
