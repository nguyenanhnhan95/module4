package com.example.use_store_proceduce.service;

import com.example.use_store_proceduce.model.Customer;

public interface ICustomerService {
    boolean insertWithStoredProcedure(Customer customer);
}
