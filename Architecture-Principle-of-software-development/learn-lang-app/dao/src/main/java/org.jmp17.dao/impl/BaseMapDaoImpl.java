package org.jmp17.dao.impl;

import org.jmp17.dao.api.BaseDao;
import org.jmp17.model.BaseModelObj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by antonsavitsky on 2/11/17.
 */
public abstract class BaseMapDaoImpl<E extends BaseModelObj>  implements BaseDao<E> {
    private Map<Integer, E> data;
    protected abstract Integer getIndex();

    public BaseMapDaoImpl() {
        data = new HashMap<Integer, E>();
    }

    public BaseMapDaoImpl(Map<Integer, E> data) {
        this.data = data;
    }

    public Map<Integer, E> getData() {
        return data;
    }

    public void setData(Map<Integer, E> data) {
        this.data = data;
    }

    @Override
    public Integer add(E e) {
        int index = getIndex();
        e.setId(index);
        data.put(index, e);
        return index;
    }

    @Override
    public List<E> retrieveAll() {
        return new ArrayList<E>( data.values() );
    }

    @Override
    public void remove(Integer id) {
        data.remove(id);
    }

    @Override
    public E retrieve(Integer id) {
        return data.get(id);
    }

    @Override
    public void update(E e) {
        data.put(e.getId(), e);
    }
}
