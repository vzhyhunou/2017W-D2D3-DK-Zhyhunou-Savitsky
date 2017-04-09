package org.jmp17.dao.jdbc.test;

import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.model.LangCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by antonsavitsky on 4/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-test-config.xml"})
@Transactional
public class BaseJdbcDaoImplTest {

    private static final LangCourse UPDATED_LANGCOURSE = new LangCourse(1, "English A1 - Speaking", "English");
    private static final LangCourse ADDED_LANGCOURSE = new LangCourse("English A2 - Business", "English");
    private static final int ALL_NUM = 2;

    @Autowired
    private LangCourseDao langCourseDao;

    @Test
    public void retrieveAllTest(){
        List<LangCourse> all = langCourseDao.retrieveAll();
        assertEquals( all.size(), ALL_NUM);
        all.forEach(System.out::println);
    }

    @Test
    public void removeByIdTest(){
        langCourseDao.remove(1);
        assertEquals( langCourseDao.retrieveAll().size(), 1 );
    }

    @Test
    public void updateTest(){
        langCourseDao.update( UPDATED_LANGCOURSE );
        LangCourse updated = langCourseDao.retrieve( UPDATED_LANGCOURSE.getId() );
        assertEquals( UPDATED_LANGCOURSE.getName(), updated.getName() );
    }

    @Test
    public void addTest(){
        langCourseDao.add( ADDED_LANGCOURSE );
        LangCourse newlyAdded = langCourseDao.retrieve(3);
        assertEquals( ADDED_LANGCOURSE.getName(), newlyAdded.getName() );
    }
    @Test
    public void getByPriceLimitTest(){
        int count = langCourseDao.getCountByPriceLimit(125.0);
        assertEquals( 1, count);
    }
}
