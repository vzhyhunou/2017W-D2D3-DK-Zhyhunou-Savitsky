package org.jmp17.dao.jpa;

import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.dao.api.TopicDao;
import org.jmp17.model.LangCourse;
import org.jmp17.model.Topic;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TopicDaoJpaImpl
  implements TopicDao
{
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Integer add( Topic topic )
  {
    entityManager.persist( topic );
    return topic.getId();
  }

  @Override
  public List<Topic> retrieveAll()
  {
    return null;
  }

  @Override
  public void remove( Integer id )
  {

  }

  @Override
  public Topic retrieve( Integer id )
  {
    return null;
  }

  @Override
  public void update( Topic topic )
  {

  }
}
