package org.jmp17.dao.api;

import org.jmp17.model.LangCourse;

import java.util.List;
import java.util.Map;

/**
 * Created by antonsavitsky on 2/9/17.
 */
public interface BaseDao<E> {
    Integer add(E e);
    Map<Integer, E> retrieveAll();
    void remove(Integer id);
    E retrieve(Integer id);
}
