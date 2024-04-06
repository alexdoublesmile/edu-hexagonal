package org.example.catalog.spi;

import org.example.catalog.data.ProductCategoryData;
import org.example.catalog.id.ProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryByIdSpi {
    Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id);
}
