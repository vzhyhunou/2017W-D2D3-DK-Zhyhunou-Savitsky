package org.jmp17.dao.jpa;

import org.jmp17.model.Test;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDaoJpaImpl extends BaseJpaImpl<Test>
{
  public TestDaoJpaImpl( )
  {
    super( Test.class );
  }

  @Override
  public List<Test> retrieveAll()
  {
    return entityManager.createQuery("SELECT test FROM Test test").getResultList();
  }
}
