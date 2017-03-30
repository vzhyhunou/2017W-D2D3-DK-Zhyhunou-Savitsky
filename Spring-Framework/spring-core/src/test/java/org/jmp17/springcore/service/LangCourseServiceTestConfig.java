package org.jmp17.springcore.service;

import org.jmp17.dao.api.LangCourseBaseDao;
import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.dao.impl.LangCourseBaseMapDaoImpl;
import org.jmp17.model.LangCourse;
import org.jmp17.model.Topic;
import org.jmp17.springcore.AttachmentsResourceFactory;
import org.jmp17.springcore.RawdataContextHolder;
import org.jmp17.springcore.session.SessionScopeData;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.context.support.SimpleThreadScope;

import java.util.*;

import static org.mockito.Mockito.mock;

/**
 * Created by antonsavitsky on 3/26/17.
 */
@Configuration
@ComponentScan(basePackages = {"org.jmp17.springcore.service", "org.jmp17.springcore.rest", "org.jmp17.springcore"})
public class LangCourseServiceTestConfig {

    @Bean
    @Scope("request")
    public LangCourseDao langCourseDao(){
        /*Map<Integer, LangCourse> data = new HashMap<>();
        data.put(1, new LangCourse(1, "English A1 course",
                Arrays.asList(new Topic(1, "Food", "Describes basic words for food", new ArrayList<>())), "English"));
        data.put(2, new LangCourse(2, "English A2 course",
                Arrays.asList(new Topic(2, "Geography", "Location naming", new ArrayList<>())), "English"));*/

        /*LangCourseBaseMapDaoImpl langCourseBaseMapDao = new LangCourseBaseMapDaoImpl();
        langCourseBaseMapDao.setData(data);
        langCourseBaseMapDao.setLastIndex(2);*/
        return mock(LangCourseDao.class);
    }


    // this is to allow use request scoped bean outside MVC
    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer customScopeConfigurer = new CustomScopeConfigurer();
        Map<String, Object> customScopes = new HashMap<>();
        customScopes.put("request", new SimpleThreadScope());
        customScopes.put("session", new SimpleThreadScope());
        customScopeConfigurer.setScopes(customScopes);
        return customScopeConfigurer;
    }

    @Bean
    @Scope("request")
    public RawdataContextHolder rawdataContextHolder(){
        return new RawdataContextHolder();
    }

    @Bean
    public AttachmentsResourceFactory attachmentsResourceFactory(){
        return new AttachmentsResourceFactory();
    }

    @Bean
    @Scope("session")
    public SessionScopeData sessionScopeData(){
        return new SessionScopeData(new Date());
    }
}
