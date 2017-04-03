package org.jmp17.dao.jdbc;

import org.springframework.util.Assert;

public class TableDescription {

	private final String name;
	private final String idColumn;

	public TableDescription(String name, String idColumn) {
		Assert.notNull(name);
		Assert.notNull(idColumn);

		this.name = name;
		this.idColumn = idColumn;
	}

	public String getName() {
		return name;
	}

	public String getIdColumn() {
		return idColumn;
	}
}
