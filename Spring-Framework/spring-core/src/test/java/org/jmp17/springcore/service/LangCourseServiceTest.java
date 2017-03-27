package org.jmp17.springcore.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;

/**
 * Created by antonsavitsky on 3/26/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {LangCourseServiceTestConfig.class})
public class LangCourseServiceTest {
    private static final int COURSE_ID_1 = 1;
    private static final int COURSE_ID_2 = 2;

    @Autowired
    private LangCourseServiceImpl langCourseService;


    @Test
    public void getCourseByIdCourseExistsTest(){
        assertNotNull( langCourseService.getCourseById(COURSE_ID_1) );
    }


}
