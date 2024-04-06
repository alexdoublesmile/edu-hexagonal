package org.example.customer.data;

import org.example.customer.id.CustomerProductCategoryId;

public record CustomerProductCategoryDto(CustomerProductCategoryId id, String title, String details) {
}
