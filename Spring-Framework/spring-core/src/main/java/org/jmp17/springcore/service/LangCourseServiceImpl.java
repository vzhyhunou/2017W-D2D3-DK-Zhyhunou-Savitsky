package org.jmp17.springcore.service;

import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.model.LangCourse;
import org.jmp17.springcore.AttachmentsResourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by antonsavitsky on 3/26/17.
 */
@Service
public class LangCourseServiceImpl implements LangCourseService {

    @Autowired
    private LangCourseDao langCourseDao;

    @Autowired
    private AttachmentsResourceFactory attachmentsResourceFactory;

    @Override
    public LangCourse getCourseById(Integer id) {
        return langCourseDao.retrieve(id);
    }

    @Override
    public LangCourse getCourseByName(String name) {
        return langCourseDao.retrieveByName(name);
    }

    @Override
    public List<LangCourse> getCoursesForLanguage(String language) {
        return langCourseDao.getByLanguage(language);
    }

    @Override
    public void removeCourse(Integer id) {
        langCourseDao.remove(id);
    }

    @Override
    public void updateCourse(LangCourse course) {
        langCourseDao.update(course);
    }

    @Override
    public Integer addCourse(LangCourse course) {
        ByteArrayResource byteArrayResource = attachmentsResourceFactory.getResource();
        return langCourseDao.add(course);
    }
}
