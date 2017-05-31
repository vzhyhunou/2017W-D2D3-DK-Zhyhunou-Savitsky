package org.jmp17.dao.jpa;

import org.jmp17.model.Question;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QuestionDaoJpaImpl extends BaseJpaImpl<Question>
{

  public QuestionDaoJpaImpl(  )
  {
    super( Question.class );
  }

  @Override
  public List<Question> retrieveAll()
  {
    return entityManager.createQuery("SELECT question FROM Question question").getResultList();
  }
}
