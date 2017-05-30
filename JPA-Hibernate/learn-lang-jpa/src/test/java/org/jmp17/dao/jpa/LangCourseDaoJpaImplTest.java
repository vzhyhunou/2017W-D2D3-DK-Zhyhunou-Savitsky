package org.jmp17.dao.jpa;

import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.model.LangCourse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-test-config.xml"})
@Transactional
public class LangCourseDaoJpaImplTest
{
  @Autowired
  private LangCourseDao langCourseDao;

  @Test
  public void addTest(){
    langCourseDao.add( new LangCourse(  ) );
  }

  @Test
  public void retrieveAlTest(){
    langCourseDao.retrieveAll();
  }
}
