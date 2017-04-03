package org.jmp17.dao.jdbc;

import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Component
public class SqlGenerator {

	public static final String WHERE = " WHERE ";
	public static final String SELECT = "SELECT ";
	public static final String FROM = "FROM ";
	public static final String DELETE = "DELETE ";
	public static final String COMMA = ", ";
	public static final String PARAM = " = ?";
	public static final String ALL_COLUMNS_CLAUSE = "*";

	public String count(TableDescription table) {
		return SELECT + "COUNT(*) " + FROM + table.getName();
	}

	public String deleteById(TableDescription table) {
		return DELETE + FROM + table.getName() + whereByIdClause(table);
	}

	private String whereByIdClause(TableDescription table) {
		return WHERE + table.getIdColumn() + PARAM;
	}

	public String selectAll(TableDescription table) {
		return SELECT + ALL_COLUMNS_CLAUSE + " " + FROM + table.getName();
	}

	public String selectById(TableDescription table) {
		return selectAll(table) + whereByIdClause(table);
	}

	public String update(TableDescription table, Map<String, Object> columns) {
		final StringBuilder updateQuery = new StringBuilder("UPDATE " + table.getName() + " SET ");
		for(Iterator<Map.Entry<String,Object>> iterator = columns.entrySet().iterator(); iterator.hasNext();) {
			Map.Entry<String, Object> column = iterator.next();
			if( column.getKey().equals("id") )
				continue;
			updateQuery.append(column.getKey()).append(" = ?");
			if (iterator.hasNext()) {
				updateQuery.append(COMMA);
			}
		}
		updateQuery.append(whereByIdClause(table));
		return updateQuery.toString();
	}

	public String create(TableDescription table, Map<String, Object> columns) {
		final StringBuilder createQuery = new StringBuilder("INSERT INTO " + table.getName() + " (");
		appendColumnNames(createQuery, columns.keySet());
		createQuery.append(")").append(" VALUES (");
		createQuery.append(repeat("?", COMMA, columns.size()));
		return createQuery.append(")").toString();
	}

	private void appendColumnNames(StringBuilder createQuery, Set<String> columnNames) {
		for(Iterator<String> iterator = columnNames.iterator(); iterator.hasNext();) {
			final String column = iterator.next();
			createQuery.append(column);
			if (iterator.hasNext()) {
				createQuery.append(COMMA);
			}
		}
	}

	private static String repeat(String s, String separator, int count) {
		StringBuilder string = new StringBuilder((s.length() + separator.length()) * count);
		while (--count > 0) {
			string.append(s).append(separator);
		}
		return string.append(s).toString();
	}

	public String countById(TableDescription table) {
		return count(table) + whereByIdClause(table);
	}
}
