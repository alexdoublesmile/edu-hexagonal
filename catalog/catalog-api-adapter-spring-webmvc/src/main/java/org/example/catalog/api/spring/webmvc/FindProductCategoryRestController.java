package org.example.catalog.api.spring.webmvc;

import org.example.catalog.api.FindProductCategoryApi;
import org.example.catalog.api.spring.webmvc.presentation.ProductCategoryPresentationV1;
import org.example.catalog.dto.CatalogProductCategoryId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindProductCategoryRestController {
    private final FindProductCategoryApi findProductCategoryApi;

    public FindProductCategoryRestController(FindProductCategoryApi findProductCategoryApi) {
        this.findProductCategoryApi = findProductCategoryApi;
    }

    @GetMapping(path = "/api/catalog/product-categories/{id:\\d+}",
            produces = "application/vnd.example.catalog.product-category.v1+json")
    public ResponseEntity<ProductCategoryPresentationV1> findProductCategory(
            @PathVariable("id") Long id
    ) {
        return findProductCategoryApi.findProductCategory(new CatalogProductCategoryId(id))
                .map(category -> ResponseEntity.ok(new ProductCategoryPresentationV1(
                        category.id().value(),
                        category.title(),
                        category.details(),
                        category.parentId() != null ? category.parentId().value() : null,
                        category.version())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
