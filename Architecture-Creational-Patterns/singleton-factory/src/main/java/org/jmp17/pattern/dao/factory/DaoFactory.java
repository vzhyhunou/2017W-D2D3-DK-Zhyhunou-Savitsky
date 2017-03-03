package org.jmp17.pattern.dao.factory;

import org.jmp17.pattern.dao.DataSourceType;
import org.jmp17.pattern.dao.api.CustomerDao;
import org.jmp17.pattern.dao.impl.DatabaseCustomerDao;
import org.jmp17.pattern.dao.impl.FileCustomerDao;
import org.jmp17.pattern.dao.impl.LazyInitFileCustomerDao;

/**
 * Created by asavitsky on 3/3/17.
 */
public class DaoFactory {
    public CustomerDao getDao(DataSourceType dataSourceType){
        CustomerDao customerDao = null;
        switch (dataSourceType){
            case FILE:
                return FileCustomerDao.getInstance();
            case FILE_LAZY:
                return LazyInitFileCustomerDao.getInstance();
            case DATABASE:
                return new DatabaseCustomerDao("db.url");
        }
        return customerDao;
    }
}
