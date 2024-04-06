package org.example.catalog.dto;

public record ProductCategoryId(Long value) {
    public static ProductCategoryId formLong(Long id) {
        return id > 0 ? new ProductCategoryId(id) : null;
    }
}
