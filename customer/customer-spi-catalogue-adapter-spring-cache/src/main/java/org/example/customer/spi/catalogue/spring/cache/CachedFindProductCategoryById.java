package org.example.customer.spi.catalogue.spring.cache;

import org.example.customer.data.CustomerProductCategoryDto;
import org.example.customer.id.CustomerProductCategoryId;
import org.example.customer.spi.catalogue.FindProductCategoryByIdSpi;
import org.springframework.cache.Cache;

import java.util.Optional;

public class CachedFindProductCategoryById implements FindProductCategoryByIdSpi {

    private final FindProductCategoryByIdSpi delegate;

    private final Cache cache;

    public CachedFindProductCategoryById(FindProductCategoryByIdSpi delegate, Cache cache) {
        this.delegate = delegate;
        this.cache = cache;
    }

    @Override
    public Optional<CustomerProductCategoryDto> findProductCategoryById(CustomerProductCategoryId id) {
        return Optional.ofNullable(this.cache.get(id.value(), CustomerProductCategoryDto.class))
                .or(() -> this.delegate.findProductCategoryById(id)
                        .map(category -> {
                            this.cache.put(category.id().value(), category);
                            return category;
                        }));
    }
}
