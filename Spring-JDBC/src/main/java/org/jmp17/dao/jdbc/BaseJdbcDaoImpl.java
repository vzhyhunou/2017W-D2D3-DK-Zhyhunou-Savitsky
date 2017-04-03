package org.jmp17.dao.jdbc;

import org.jmp17.dao.api.BaseDao;
import org.jmp17.model.LangCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by antonsavitsky on 4/2/17.
 */
@Repository
public class BaseJdbcDaoImpl implements BaseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer add(Object o) {
        return null;
    }

    @Override
    public List retrieveAll() {
        return jdbcTemplate.query( "select * from LANGCOURSE", new LangCourseRowMapper() );
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public Object retrieve(Integer id) {
        return null;
    }

    @Override
    public void update(Object o) {

    }

    private static final class LangCourseRowMapper implements RowMapper<LangCourse>{

        @Override
        public LangCourse mapRow(ResultSet resultSet, int i) throws SQLException {
            LangCourse langCourse = new LangCourse();
            langCourse.setId( resultSet.getInt("id") );
            langCourse.setName( resultSet.getString("name") );
            langCourse.setLanguage( resultSet.getString("language") );
            return langCourse;
        }
    }
}
