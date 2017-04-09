package org.jmp17.dao.impl;

import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.model.LangCourse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by antonsavitsky on 2/9/17.
 */
@Component
public class LangCourseBaseMapDaoImpl
        extends BaseMapDaoImpl<LangCourse>
        implements LangCourseDao {

    private static int lastIndex;

    public void setLastIndex(int lastIndex) {
        LangCourseBaseMapDaoImpl.lastIndex = lastIndex;
    }

    @Override
    protected Integer getIndex() {
        return ++lastIndex;
    }

    @Override
    public LangCourse retrieveByName(String name) {
        return getData().entrySet().stream()
                .filter(e -> e.getValue().getName().equals(name))
                .map(m -> m.getValue())
                .findFirst()
                .orElse(new LangCourse());
    }

    @Override
    public List<LangCourse> getByLanguage(String lang) {
        return getData().entrySet().stream()
                .filter(e -> e.getValue().getLanguage().equals(lang))
                .map(m -> m.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public Integer getCountByPriceLimit(Double priceLimit) {
        return null;
    }

}
