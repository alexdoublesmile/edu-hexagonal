package org.example.catalog.usecase;

import org.example.catalog.api.FindProductCategoryApi;
import org.example.catalog.dto.CatalogProductCategoryDto;
import org.example.catalog.dto.CatalogProductCategoryId;
import org.example.catalog.spi.FindProductCategoryByIdSpi;

import java.util.Optional;

public class FindProductCategoryUsecase implements FindProductCategoryApi {
    private final FindProductCategoryByIdSpi findProductCategoryByIdSpi;

    public FindProductCategoryUsecase(FindProductCategoryByIdSpi findProductCategoryByIdSpi) {
        this.findProductCategoryByIdSpi = findProductCategoryByIdSpi;
    }

    @Override
    public Optional<CatalogProductCategoryDto> findProductCategory(CatalogProductCategoryId id) {
        return findProductCategoryByIdSpi.findProductCategoryById(id);
    }
}
