package org.jmp17.dao.impl;

import org.jmp17.model.LangCourse;
import org.springframework.stereotype.Component;

/**
 * Created by antonsavitsky on 2/9/17.
 */
@Component
public class LangCourseBaseMapDaoImpl extends BaseMapDaoImpl<LangCourse> {
    private static int lastIndex;

    public void setLastIndex(int lastIndex) {
        LangCourseBaseMapDaoImpl.lastIndex = lastIndex;
    }

    @Override
    protected Integer getIndex() {
        return ++lastIndex;
    }
}
