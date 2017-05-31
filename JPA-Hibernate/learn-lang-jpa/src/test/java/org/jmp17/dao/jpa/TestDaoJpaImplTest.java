package org.jmp17.dao.jpa;

import org.jmp17.dao.api.BaseDao;
import org.jmp17.model.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-test-config.xml"})
@Transactional
public class TestDaoJpaImplTest
{

  @Autowired
  private BaseDao<Test> testDao;

  @org.junit.Test
  public void addTest(){
    Test test = new Test(  );
    testDao.add( test );
  }
}
