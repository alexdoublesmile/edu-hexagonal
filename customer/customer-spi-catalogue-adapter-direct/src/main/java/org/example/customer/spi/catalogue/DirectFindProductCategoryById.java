package org.example.customer.spi.catalogue;

import org.example.customer.data.CustomerProductCategoryDto;
import org.example.customer.id.CustomerProductCategoryId;
import org.example.catalog.api.FindProductCategoryApi;
import org.example.catalog.dto.CatalogProductCategoryId;

import java.util.Optional;

public class DirectFindProductCategoryById implements FindProductCategoryByIdSpi {

    private final FindProductCategoryApi findProductCategoryApi;

    public DirectFindProductCategoryById(FindProductCategoryApi findProductCategoryApi) {
        this.findProductCategoryApi = findProductCategoryApi;
    }

    @Override
    public Optional<CustomerProductCategoryDto> findProductCategoryById(CustomerProductCategoryId id) {
        return this.findProductCategoryApi.findProductCategory(
                new CatalogProductCategoryId(id.value()))
                .map(category -> new CustomerProductCategoryDto(new CustomerProductCategoryId(category.id().value()),
                        category.title(), category.details()));
    }
}
