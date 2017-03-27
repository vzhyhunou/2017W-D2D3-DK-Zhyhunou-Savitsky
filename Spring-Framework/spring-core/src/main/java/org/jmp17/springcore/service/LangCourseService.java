package org.jmp17.springcore.service;

import org.jmp17.model.LangCourse;
import java.util.List;

/**
 * Created by antonsavitsky on 3/26/17.
 */
public interface LangCourseService {
    LangCourse getCourseById(Integer id);
    LangCourse getCourseByName(String name);
    List<LangCourse> getCoursesForLanguage(String language);
    void removeCourse(Integer id);
    void updateCourse(LangCourse course);
    Integer addCourse(LangCourse course);
}
