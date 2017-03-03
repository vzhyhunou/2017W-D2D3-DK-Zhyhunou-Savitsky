package org.jmp17.pattern.dao.impl;

import org.jmp17.pattern.dao.api.CustomerDao;
import org.jmp17.pattern.model.Customer;

/**
 * Created by asavitsky on 3/3/17.
 */
// this is a normal singleton implementation, not a lazy one
public class FileCustomerDao implements CustomerDao {
    public static final FileCustomerDao INSTANCE = new FileCustomerDao();
    private FileCustomerDao(){}

    public static CustomerDao getInstance(){
        return INSTANCE;
    }

    public void create(Customer customer) {
        System.out.println(this.getClass().getSimpleName() + ": New customer was successfully created.");
    }

    public void update(Customer customer) {
        System.out.println(this.getClass().getSimpleName() + ": Customer was successfully updated.");
    }

    public void delete(Customer customer) {
        System.out.println(this.getClass().getSimpleName() + ": Customer was deleted.");
    }
}
