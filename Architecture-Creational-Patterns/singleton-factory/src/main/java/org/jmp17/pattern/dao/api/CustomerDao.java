package org.jmp17.pattern.dao.api;

import org.jmp17.pattern.model.Customer;

/**
 * Created by asavitsky on 3/3/17.
 */
public interface CustomerDao {
    void create(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
}
