package org.example.catalog.api;

import org.example.catalog.data.ProductCategoryData;
import org.example.catalog.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryApi {
    Optional<ProductCategoryData> findProductCategoryApi(ProductCategoryId id);
}
