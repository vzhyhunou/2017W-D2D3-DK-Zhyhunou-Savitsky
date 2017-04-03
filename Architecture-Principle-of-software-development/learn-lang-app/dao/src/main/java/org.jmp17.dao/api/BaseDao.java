package org.jmp17.dao.api;

import java.util.List;

/**
 * Created by antonsavitsky on 2/9/17.
 */
public interface BaseDao<E> {
    Integer add(E e);
    List<E> retrieveAll();
    void remove(Integer id);
    E retrieve(Integer id);
    void update(E e);
}
