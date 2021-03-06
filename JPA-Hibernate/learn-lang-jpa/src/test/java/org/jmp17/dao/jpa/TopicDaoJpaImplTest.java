package org.jmp17.dao.jpa;

import org.jmp17.dao.api.BaseDao;
import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.model.Topic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-test-config.xml"})
@Transactional
public class TopicDaoJpaImplTest
{

  @Autowired
  private BaseDao<Topic> topicDao;

  @Autowired
  private LangCourseDao langCourseDao;

  @Test
  public void addTest(){
    int countBeforeAdd = 1;
    topicDao.add( new Topic( "1st Chapter", "Basic spoken language", 1 ) );
    assertEquals( countBeforeAdd + 1, topicDao.retrieveAll().size() );
  }
}
