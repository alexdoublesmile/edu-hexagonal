package org.example.customer.api.spring.webmvc;

import org.example.customer.api.FindProductCategoryApi;
import org.example.customer.api.spring.webmvc.presentation.ProductCategoryPresentationV1;
import org.example.customer.id.CustomerProductCategoryId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerFindProductCategoryRestController {

    private final FindProductCategoryApi findProductCategoryApi;

    public CustomerFindProductCategoryRestController(FindProductCategoryApi findProductCategoryApi) {
        this.findProductCategoryApi = findProductCategoryApi;
    }

    @GetMapping(path = "/customer-api/catalogue/product-categories/{id:\\d+}",
            produces = "application/vnd.selmag.customer.product-category.v1+json")
    public ResponseEntity<ProductCategoryPresentationV1> findProductCategory(@PathVariable("id") Long id) {
        return this.findProductCategoryApi.findProductCategory(new CustomerProductCategoryId(id))
                .map(category -> ResponseEntity.ok(new ProductCategoryPresentationV1(category.id().value(),
                        category.title(), category.details())))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
