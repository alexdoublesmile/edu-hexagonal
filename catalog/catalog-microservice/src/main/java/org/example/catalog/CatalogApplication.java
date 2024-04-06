package org.example.catalog;

import org.example.catalog.spi.spring.jdbc.MappingSqlQueryFindProductCategoryById;
import org.example.catalog.usecase.FindProductCategoryUsecase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class CatalogApplication {
    public static void main(String[] args) {
        SpringApplication.run(CatalogApplication.class, args);
    }

    @Bean
    FindProductCategoryUsecase findProductCategoryUsecase(DataSource dataSource) {
        return new FindProductCategoryUsecase(
                new MappingSqlQueryFindProductCategoryById(dataSource));
    }
}
