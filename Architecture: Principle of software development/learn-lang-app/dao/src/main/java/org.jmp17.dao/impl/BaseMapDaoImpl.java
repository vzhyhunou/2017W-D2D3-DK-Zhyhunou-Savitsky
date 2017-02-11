package org.jmp17.dao.impl;

import org.jmp17.dao.api.BaseDao;
import org.jmp17.model.BaseModelObj;

import java.util.Map;

/**
 * Created by antonsavitsky on 2/11/17.
 */
public abstract class BaseMapDaoImpl<I extends BaseModelObj>  implements BaseDao<I> {
    private Map<Integer, I> data;
    protected abstract Integer getIndex();

    public Map<Integer, I> getData() {
        return data;
    }

    public void setData(Map<Integer, I> data) {
        this.data = data;
    }

    @Override
    public Integer add(I i) {
        int index = getIndex();
        i.setId(index);
        data.put(index, i);
        return index;
    }

    @Override
    public Map<Integer, I> retrieveAll() {
        return data;
    }

    @Override
    public void remove(Integer id) {
        data.remove(id);
    }

    @Override
    public I retrieve(Integer id) {
        return data.get(id);
    }
}
