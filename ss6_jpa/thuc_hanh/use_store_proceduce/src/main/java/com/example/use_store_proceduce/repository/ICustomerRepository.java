package com.example.use_store_proceduce.repository;

import com.example.use_store_proceduce.model.Customer;

public interface ICustomerRepository {
    boolean insertWithStoredProcedure(Customer customer);
}
