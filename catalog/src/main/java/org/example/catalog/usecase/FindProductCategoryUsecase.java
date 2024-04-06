package org.example.catalog.usecase;

import org.example.catalog.api.FindProductCategoryApi;
import org.example.catalog.data.ProductCategoryData;
import org.example.catalog.id.ProductCategoryId;
import org.example.catalog.spi.FindProductCategoryByIdSpi;

import java.util.Optional;

public class FindProductCategoryUsecase implements FindProductCategoryApi {
    private final FindProductCategoryByIdSpi findProductCategoryByIdSpi;

    public FindProductCategoryUsecase(FindProductCategoryByIdSpi findProductCategoryByIdSpi) {
        this.findProductCategoryByIdSpi = findProductCategoryByIdSpi;
    }

    @Override
    public Optional<ProductCategoryData> findProductCategoryApi(ProductCategoryId id) {
        return findProductCategoryByIdSpi.findProductCategoryById(id);
    }
}
