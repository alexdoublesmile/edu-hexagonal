package org.example.catalog.dto;

public record CatalogProductCategoryId(Long value) {
    public static CatalogProductCategoryId formLong(Long id) {
        return id > 0 ? new CatalogProductCategoryId(id) : null;
    }
}
