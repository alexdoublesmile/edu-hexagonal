package org.example.customer.spi.catalogue;

import org.example.customer.data.CustomerProductCategoryDto;
import org.example.customer.id.CustomerProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryByIdSpi {

    Optional<CustomerProductCategoryDto> findProductCategoryById(CustomerProductCategoryId id);
}
