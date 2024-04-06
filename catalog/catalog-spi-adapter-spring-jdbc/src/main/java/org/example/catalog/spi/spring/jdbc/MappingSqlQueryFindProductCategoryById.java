package org.example.catalog.spi.spring.jdbc;

import org.example.catalog.dto.ProductCategoryDto;
import org.example.catalog.dto.ProductCategoryId;
import org.example.catalog.spi.FindProductCategoryByIdSpi;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Map;
import java.util.Optional;

public class MappingSqlQueryFindProductCategoryById
        extends MappingSqlQuery<ProductCategoryDto> implements FindProductCategoryByIdSpi {
    public MappingSqlQueryFindProductCategoryById(DataSource ds) {
        super(ds, """
            select id, c_title, c_details, id_parent, c_version
            from catalog.v_product_category_v1
            where id = :id
            """);
        declareParameter(new SqlParameter("id", Types.BIGINT));
        compile();
    }

    @Override
    public Optional<ProductCategoryDto> findProductCategoryById(ProductCategoryId id) {
        return Optional.ofNullable(findObjectByNamedParam(Map.of("id", id.value())));
    }

    @Override
    protected ProductCategoryDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductCategoryDto(
                new ProductCategoryId(rs.getLong("id")),
                rs.getString("c_title"),
                rs.getString("c_details"),
                ProductCategoryId.formLong(rs.getLong("id_parent")),
                rs.getInt("c_version")
        );
    }
}
