package com.example.use_store_proceduce.service.impl;


import com.example.use_store_proceduce.model.Customer;
import com.example.use_store_proceduce.repository.ICustomerRepository;
import com.example.use_store_proceduce.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean insertWithStoredProcedure(Customer customer) {
        return customerRepository.insertWithStoredProcedure(customer);
    }
}