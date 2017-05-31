package org.jmp17.dao.jpa;

import org.jmp17.dao.api.BaseDao;
import org.jmp17.model.Question;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-test-config.xml"})
@Transactional
public class QuestionDaoJpaImplTest
{
  @Autowired
  private BaseDao<Question> questionDao;

  @Test
  public void addTest(){
    ArrayList<String> answers = new ArrayList<>();
    answers.add( "1 answer" );
    answers.add( "2 answer" );
    ArrayList<String> rightAnswers = new ArrayList<>();
    rightAnswers.add( "right answer" );
    Question question = new Question( "QuestionTextValue", answers, rightAnswers );

    questionDao.add( question );
    assertEquals( 1, questionDao.retrieveAll().size() );
  }

}
