package org.jmp17.dao.jpa;

import org.jmp17.dao.api.LangCourseDao;
import org.jmp17.model.LangCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public class LangCourseDaoJpaImpl extends BaseJpaImpl<LangCourse> implements
  LangCourseDao
{
  public LangCourseDaoJpaImpl( )
  {
    super( LangCourse.class );
  }

  @Override
  public List<LangCourse> retrieveAll()
  {
    return entityManager.createQuery("SELECT course FROM LangCourse course").getResultList();
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
