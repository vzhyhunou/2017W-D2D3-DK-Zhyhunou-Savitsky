package org.jmp17.dao.jpa;

import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.model.LangCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class LangCourseDaoJpaImpl implements LangCourseDao
{
  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Integer add( LangCourse langCourse )
  {
    entityManager.persist( langCourse );
    return null;
  }

  @Override
  public List<LangCourse> retrieveAll()
  {
    return entityManager.createQuery("SELECT course FROM LangCourse course").getResultList();
  }

  @Override
  public void remove( Integer id )
  {

  }

  @Override
  public LangCourse retrieve( Integer id )
  {
    return null;
  }

  @Override
  public void update( LangCourse langCourse )
  {

  }

  @Override
  public LangCourse retrieveByName( String name )
  {
    return null;
  }

  @Override
  public List<LangCourse> getByLanguage( String lang )
  {
    return null;
  }

  @Override
  public Integer getCountByPriceLimit( Double priceLimit )
  {
    return null;
  }
}
