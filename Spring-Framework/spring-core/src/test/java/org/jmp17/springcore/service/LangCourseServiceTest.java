package org.jmp17.springcore.service;

import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.model.LangCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

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

    @Autowired
    private LangCourseDao langCourseDao;

    @Test
    public void getCourseByIdCourseExistsTest(){
        when( langCourseDao.retrieve( anyInt() ) ).thenReturn( new LangCourse() );
        assertNotNull( langCourseService.getCourseById( COURSE_ID_1 ) );
        verify( langCourseDao, times(1) ).retrieve( COURSE_ID_1 );
    }
}
