package org.jmp17.dao.jdbc;

import org.jmp17.dao.api.BaseDao;
import org.jmp17.model.BaseModelObj;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by antonsavitsky on 4/2/17.
 */
public class BaseJdbcDaoImpl<T extends BaseModelObj> implements BaseDao<T> {
    private JdbcTemplate jdbcTemplate;

    private SqlGenerator sqlGenerator;

    private RowMapper<T> rowMapper;
    private RowUnmapper<T> rowUnmapper;
    private TableDescription table;

    public BaseJdbcDaoImpl(RowMapper<T> rowMapper, RowUnmapper<T> rowUnmapper,
                           TableDescription table, JdbcTemplate jdbcTemplate,
                           SqlGenerator sqlGenerator) {
        this.rowMapper = rowMapper;
        this.rowUnmapper = rowUnmapper;
        this.table = table;
        this.jdbcTemplate = jdbcTemplate;
        this.sqlGenerator = sqlGenerator;
    }

    @Override
    public Integer add(T t) {
        Map<String, Object> columns = rowUnmapper.mapColumns(t);
        final String updateQuery = sqlGenerator.create(table, columns);
        final Object[] queryParams = columns.values().toArray();
        return jdbcTemplate.update( updateQuery, queryParams )+1;
    }

    @Override
    public List<T> retrieveAll() {
        return jdbcTemplate.query( sqlGenerator.selectAll(table), rowMapper);
    }

    @Override
    public void remove(Integer id) {
        jdbcTemplate.update(sqlGenerator.deleteById(table), id);
    }

    @Override
    public T retrieve(Integer id) {
        return jdbcTemplate.queryForObject(sqlGenerator.selectById(table), new Object[]{id}, rowMapper);
    }

    @Override
    public void update(T t) {
        final Map<String, Object> columns = columns(t);
        final String updateQuery = sqlGenerator.update(table, columns);
        columns.put(table.getIdColumn(), t.getId());
        final Object[] queryParams = columns.values().toArray();
        jdbcTemplate.update(updateQuery, queryParams);
    }

    public JdbcTemplate getJdbcTemplate(){
        return this.jdbcTemplate;
    }

    public TableDescription getTableDescription(){
        return this.table;
    }

    private LinkedHashMap<String, Object> columns(T entity) {
        return new LinkedHashMap<String, Object>(rowUnmapper.mapColumns(entity));
    }
}
