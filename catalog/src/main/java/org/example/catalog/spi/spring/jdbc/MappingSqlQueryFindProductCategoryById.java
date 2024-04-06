package org.example.catalog.spi.spring.jdbc;

import org.example.catalog.data.ProductCategoryData;
import org.example.catalog.id.ProductCategoryId;
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
        extends MappingSqlQuery<ProductCategoryData> implements FindProductCategoryByIdSpi {
    public MappingSqlQueryFindProductCategoryById(DataSource ds) {
        super(ds, """
            select id, c_title, c_details, id_parent, c_version
            from calalog.v_product_category_v1
            where id = :id
            """);
        declareParameter(new SqlParameter("id", Types.BIGINT));
        compile();
    }

    @Override
    public Optional<ProductCategoryData> findProductCategoryById(ProductCategoryId id) {
        return Optional.ofNullable(findObjectByNamedParam(Map.of("id", id.value())));
    }

    @Override
    protected ProductCategoryData mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new ProductCategoryData(
                new ProductCategoryId(rs.getLong("id")),
                rs.getString("c_title"),
                rs.getString("c_details"),
                ProductCategoryId.formLong(rs.getLong("id_parent")),
                rs.getInt("c_version")
        );
    }
}
