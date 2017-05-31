package org.jmp17.dao.jpa;

import org.jmp17.model.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicDaoJpaImpl
  extends BaseJpaImpl<Topic>
{
  public TopicDaoJpaImpl(  )
  {
    super( Topic.class );
  }

  @Override
  public List<Topic> retrieveAll()
  {
    return entityManager.createQuery("SELECT topic FROM Topic topic").getResultList();
  }
}
