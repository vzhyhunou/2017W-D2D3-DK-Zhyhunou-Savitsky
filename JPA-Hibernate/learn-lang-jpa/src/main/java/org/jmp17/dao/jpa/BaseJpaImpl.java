package org.jmp17.dao.jpa;

import org.jmp17.dao.api.BaseDao;
import org.jmp17.model.BaseModelObj;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class BaseJpaImpl<T extends BaseModelObj> implements BaseDao<T>
{
  @PersistenceContext
  protected EntityManager entityManager;

  private Class<T> tClass;

  public BaseJpaImpl(Class tClass){
    this.tClass = tClass;
  }

  @Override
  public Integer add( T t )
  {
    entityManager.persist( t );
    return t.getId();
  }

  @Override
  public abstract List<T> retrieveAll();

  @Override
  public void remove( Integer id )
  {
    T t = retrieve( id );
    entityManager.remove( t );
  }

  @Override
  public T retrieve( Integer id )
  {
    return entityManager.find( tClass, id );
  }

  @Override
  public void update( T t )
  {
    entityManager.merge( t );
  }
}
