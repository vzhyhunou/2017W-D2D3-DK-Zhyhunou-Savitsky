package org.jmp17.dao.test.config;

import org.jmp17.dao.impl.LangCourseBaseMapDaoImpl;
import org.jmp17.model.LangCourse;
import org.jmp17.model.Test;
import org.jmp17.model.Topic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.*;

/**
 * Created by antonsavitsky on 2/11/17.
 */
@Configuration
public class LangCourseMapDaoImplTestConfig {

    @Bean
    @Scope("prototype")
    public LangCourseBaseMapDaoImpl langCourseListDaoImpl(){
        Map<Integer, LangCourse> courseData = new HashMap<>();
        courseData.put(1, new LangCourse(1, "Business language",
                Arrays.asList(new Topic("Basic glossary", "This is to make you familiar with basic terms", new ArrayList<Test>())),
                "English"));

        LangCourseBaseMapDaoImpl langCourseMapDaoImpl = new LangCourseBaseMapDaoImpl();
        langCourseMapDaoImpl.setData(courseData);
        langCourseMapDaoImpl.setLastIndex(1);
        return langCourseMapDaoImpl;
    }
}
