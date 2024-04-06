package org.example.customer.spi.catalogue.spring.web;

import org.example.customer.data.CustomerProductCategoryDto;
import org.example.customer.id.CustomerProductCategoryId;
import org.example.customer.spi.catalogue.FindProductCategoryByIdSpi;
import org.example.customer.spi.catalogue.spring.web.presentation.ProductCategoryPresentationV1;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClient;

import java.util.Optional;

public class RestClientFindProductCategoryByIdSpi implements FindProductCategoryByIdSpi {

    private final RestClient restClient;

    public RestClientFindProductCategoryByIdSpi(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public Optional<CustomerProductCategoryDto> findProductCategoryById(CustomerProductCategoryId id) {
        return this.restClient.get()
                .uri("http://localhost:8081/api/catalogue/product-categories/%d".formatted(id.value()))
                .exchange((req, res) -> {
                    if (res.getStatusCode() == HttpStatus.OK) {
                        return Optional.of(res.bodyTo(ProductCategoryPresentationV1.class))
                                .map(payload ->
                                        new CustomerProductCategoryDto(new CustomerProductCategoryId(payload.id()),
                                                payload.title(), payload.details()));
                    }

                    return Optional.empty();
                });
    }
}
