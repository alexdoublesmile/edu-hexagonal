package org.example.catalog.spi.spring.jdbc;

import org.example.catalog.data.ProductCategoryData;
import org.example.catalog.id.ProductCategoryId;
import org.example.catalog.spi.FindProductCategoryByIdSpi;

import java.util.Optional;

public class JdbcClientFindProductCategoryById implements FindProductCategoryByIdSpi {
    @Override
    public Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id) {
        return Optional.empty();
    }
}
