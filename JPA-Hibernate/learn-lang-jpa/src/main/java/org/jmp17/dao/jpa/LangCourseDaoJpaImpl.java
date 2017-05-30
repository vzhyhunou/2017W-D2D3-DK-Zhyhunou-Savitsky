package org.jmp17.dao.jpa;

import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.model.LangCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    return langCourse.getId();
  }

  @Override
  public List<LangCourse> retrieveAll()
  {
    return entityManager.createQuery("SELECT course FROM LangCourse course").getResultList();
  }

  @Override
  public void remove( Integer id )
  {
    LangCourse langCourse = retrieve( id );
    entityManager.remove( langCourse );
  }

  @Override
  public LangCourse retrieve( Integer id )
  {
    Query query = entityManager.createQuery( "SELECT course FROM LangCourse course WHERE course.id =:id", LangCourse.class );
    query.setParameter( "id", id );
    return (LangCourse)query.getSingleResult();
  }

  @Override
  public void update( LangCourse langCourse )
  {
    entityManager.merge( langCourse );
  }

  @Override
  public LangCourse retrieveByName( String name )
  {
    Query query = entityManager.createQuery( "SELECT course FROM LangCourse course WHERE course.name = :name", LangCourse.class );
    query.setParameter( "name", name );
    return (LangCourse)query.getSingleResult();
  }

  @Override
  public List<LangCourse> getByLanguage( String lang )
  {
    Query query = entityManager.createQuery( "SELECT course FROM LangCourse course WHERE course.language =:language" );
    query.setParameter( "language", lang );
    return query.getResultList();
  }

  @Override
  public Integer getCountByPriceLimit( Double priceLimit )
  {
    return Math.toIntExact( entityManager.createQuery( new StringBuilder(
      "SELECT count(course) FROM LangCourse course WHERE course.price < " ).append(
      priceLimit ).toString(), Long.class ).getSingleResult() );
  }
}
