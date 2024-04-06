package org.example.catalog.api.spring.webmvc.presentation;

public record ProductCategoryPresentationV1(
        Long id,
        String title,
        String details,
        Long parentId,
        int version) {
}
