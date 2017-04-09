package org.jmp17.dao.jdbc;

import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.model.LangCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Created by asavitsky on 4/3/17.
 */
@Repository
public class LangCourseJdbcDaoImpl
    extends BaseJdbcDaoImpl<LangCourse>
    implements LangCourseDao {

    private static final String SELECT_BY_NAME = "select * from ? where name = ?";
    private static final String SELECT_BY_LANGUAGE = "select * from ? where language = ?";
    private static final String SELECT_COUNT_BY_PRICE_LIMIT = "select count(*) from $tableName where price <= ?";
    private static final RowMapper<LangCourse> MAPPER = (rs, rowNum) -> new LangCourse(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("language"),
            rs.getDouble("price")
    );

    private static final RowUnmapper<LangCourse> ROW_UNMAPPER = langCourse -> {
        Map<String, Object> mapping = new LinkedHashMap<String, Object>();
        mapping.put("name", langCourse.getName());
        mapping.put("language", langCourse.getLanguage());
        mapping.put("price", langCourse.getPrice());
        return mapping;
    };

    private static final TableDescription table = new TableDescription("LANGCOURSE", "id");

    @Autowired
    public LangCourseJdbcDaoImpl(JdbcTemplate jdbcTemplate, SqlGenerator sqlGenerator) {
        super(MAPPER, ROW_UNMAPPER, table, jdbcTemplate, sqlGenerator );
    }

    @Override
    public LangCourse retrieveByName(String name) {
        return getJdbcTemplate().queryForObject(SELECT_BY_NAME,
                                                new Object[] { getTableDescription().getName(), name},
                                                MAPPER);
    }

    @Override
    public List<LangCourse> getByLanguage(String lang) {
        return getJdbcTemplate().query(SELECT_BY_LANGUAGE,
              new Object[] { getTableDescription().getName(), lang}, MAPPER);
    }

    @Override
    public Integer getCountByPriceLimit(Double priceLimit) {
        return getJdbcTemplate().queryForObject(SELECT_COUNT_BY_PRICE_LIMIT.replace("$tableName", table.getName()),
                                                new Object[]{priceLimit},
                                                Integer.class);
    }
}
