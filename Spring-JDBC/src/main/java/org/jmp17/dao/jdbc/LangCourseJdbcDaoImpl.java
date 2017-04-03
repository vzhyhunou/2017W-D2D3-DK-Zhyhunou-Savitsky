package org.jmp17.dao.jdbc;

import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.model.LangCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by asavitsky on 4/3/17.
 */
@Repository
public class LangCourseJdbcDaoImpl
    extends BaseJdbcDaoImpl<LangCourse>
    implements LangCourseDao {

    private static final String SELECT_BY_NAME = "select * from ? where name = ?";
    private static final String SELECT_BY_LANGUAGE = "select * from ? where language = ?";
    private static final RowMapper<LangCourse> MAPPER = (rs, rowNum) -> new LangCourse(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("language")
    );

    private static final RowUnmapper<LangCourse> ROW_UNMAPPER = langCourse -> {
        Map<String, Object> mapping = new LinkedHashMap<String, Object>();
        mapping.put("name", langCourse.getName());
        mapping.put("language", langCourse.getLanguage());
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
}
