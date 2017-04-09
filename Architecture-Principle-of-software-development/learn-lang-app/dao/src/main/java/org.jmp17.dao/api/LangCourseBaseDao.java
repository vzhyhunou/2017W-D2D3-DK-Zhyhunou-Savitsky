package org.jmp17.dao.api;

import org.jmp17.model.LangCourse;

import java.util.List;

/**
 * Created by antonsavitsky on 3/26/17.
 */
public interface LangCourseBaseDao {
    LangCourse retrieveByName(String name);
    List<LangCourse> getByLanguage(String lang);
    Integer getCountByPriceLimit(Double priceLimit);
}
