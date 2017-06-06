package org.jmp17.dao.api;

import java.util.List;

/**
 * Created by antonsavitsky on 2/9/17.
 */
public interface BaseDao<E> {
    Integer add(E e);
    List<E> retrieveAll();
    void remove(Integer id) throws NotFoundException;
    E retrieve(Integer id) throws NotFoundException;
    void update(E e);
}
