package org.jmp17.pattern;

import org.jmp17.pattern.dao.DataSourceType;
import org.jmp17.pattern.dao.api.CustomerDao;
import org.jmp17.pattern.dao.factory.DaoFactory;
import org.jmp17.pattern.model.Customer;

/**
 * Created by asavitsky on 3/3/17.
 */
public class App {
    public static void main(String[] args) {
        DaoFactory daoFactory = new DaoFactory();
        CustomerDao databaseCustomerDao = daoFactory.getDao(DataSourceType.DATABASE);
        databaseCustomerDao.create(new Customer("Ivan Ivanou","Minsk, Belarus"));
        System.out.println("Database dao hashCode: " + databaseCustomerDao.hashCode());
        CustomerDao databaseCustomerDao1 = daoFactory.getDao(DataSourceType.DATABASE);
        System.out.println("Database dao1 hashCode: " + databaseCustomerDao1.hashCode());

        CustomerDao fileCustomerDao = daoFactory.getDao(DataSourceType.FILE);
        fileCustomerDao.create(new Customer("Ivan Ivanou","Minsk, Belarus"));

        CustomerDao lazyInitCustomerDao = daoFactory.getDao(DataSourceType.FILE_LAZY);
        System.out.println("File dao hashCode: " + lazyInitCustomerDao.hashCode());
        CustomerDao lazyInitCustomerDao1 = daoFactory.getDao(DataSourceType.FILE_LAZY);
        System.out.println("File dao2 hashCode: " + lazyInitCustomerDao1.hashCode());
    }
}
