package org.jmp17.dao.jpa;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-test-config.xml"})
@Transactional
public class LangCourseDaoJpaImplTest
{
  @Autowired
  private LangCourseDao langCourseDao;

  @Test
  public void addTest(){
    int countBeforeAdd = 2;
    langCourseDao.add( new LangCourse( ) );
    assertEquals( countBeforeAdd + 1, langCourseDao.retrieveAll().size() );
  }

  @Test
  public void retrieveAllTest(){
    int allCount = langCourseDao.retrieveAll().size();
    assertEquals( 2, allCount );
  }

  @Test
  public void retrieveTest(){
    assertEquals( "English A1", langCourseDao.retrieve( 1 ).getName() );
  }

  @Test
  public void removeTest(){
    langCourseDao.remove( 2 );
    assertEquals( 1, langCourseDao.retrieveAll( ).size() );
  }

  @Test
  public void retrieveByNameTest(){
    assertEquals( 1, langCourseDao.retrieveByName( "English A1" ).getId().intValue() );
  }

  @Test
  public void getByLanguageTest(){
    List<LangCourse> langCourses= langCourseDao.getByLanguage( "English" );
    assertEquals( 2, langCourses.size() );
  }

  @Test
  public void getCountByPriceLimitTest(){
    int countbyPriceLimit = langCourseDao.getCountByPriceLimit( 150.0 );
    assertEquals( 1, countbyPriceLimit );
  }
}
