package org.jmp17.pattern.dao.impl;

import org.jmp17.pattern.dao.api.CustomerDao;
import org.jmp17.pattern.model.Customer;

/**
 * Created by asavitsky on 3/3/17.
 */
public class LazyInitFileCustomerDao implements CustomerDao {
    private static LazyInitFileCustomerDao instance;

    public static synchronized CustomerDao getInstance() {
        if (instance == null) {
            instance = new LazyInitFileCustomerDao();
        }
        return instance;
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
