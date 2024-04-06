package org.example.customer.api.usecase;

import org.example.customer.api.FindProductCategoryApi;
import org.example.customer.data.CustomerProductCategoryDto;
import org.example.customer.id.CustomerProductCategoryId;
import org.example.customer.spi.catalogue.FindProductCategoryByIdSpi;

import java.util.Optional;

public class CustomerFindProductCategoryUseCase implements FindProductCategoryApi {

    private final FindProductCategoryByIdSpi findProductCategoryByIdSpi;

    public CustomerFindProductCategoryUseCase(FindProductCategoryByIdSpi findProductCategoryByIdSpi) {
        this.findProductCategoryByIdSpi = findProductCategoryByIdSpi;
    }

    @Override
    public Optional<CustomerProductCategoryDto> findProductCategory(CustomerProductCategoryId id) {
        return this.findProductCategoryByIdSpi
                .findProductCategoryById(id);
    }
}
