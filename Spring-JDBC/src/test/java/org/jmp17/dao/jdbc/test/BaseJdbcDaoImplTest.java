package org.jmp17.dao.jdbc.test;

import org.jmp17.dao.api.BaseDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by antonsavitsky on 4/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dao-test-config.xml"})
public class BaseJdbcDaoImplTest {

    @Autowired
    private BaseDao baseDao;

    @Test
    public void retrieveAllTest(){
        List all = baseDao.retrieveAll();
        System.out.println( all.get(0) );
    }
}
