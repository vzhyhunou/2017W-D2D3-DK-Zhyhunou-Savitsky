package org.jmp17.dao.jdbc;

import org.jmp17.model.BaseModelObj;

import java.util.Map;

/**
 * Created by asavitsky on 4/3/17.
 */
public interface RowUnmapper<T extends BaseModelObj> {
    Map<String, Object> mapColumns(T t);
}
