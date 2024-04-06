package org.example.customer.api;

import org.example.customer.data.CustomerProductCategoryDto;
import org.example.customer.id.CustomerProductCategoryId;

import java.util.Optional;

@FunctionalInterface
public interface FindProductCategoryApi {

    Optional<CustomerProductCategoryDto> findProductCategory(CustomerProductCategoryId id);
}
