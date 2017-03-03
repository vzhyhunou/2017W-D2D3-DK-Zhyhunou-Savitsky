package org.jmp17.pattern.dao.impl;

import org.jmp17.pattern.dao.api.CustomerDao;
import org.jmp17.pattern.model.Customer;

/**
 * Created by asavitsky on 3/3/17.
 */
public class DatabaseCustomerDao implements CustomerDao {
    private String databaseUrl;

    public DatabaseCustomerDao(String databaseUrl) {
        this.databaseUrl = databaseUrl;
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
