package com.customer.service.service;

import com.customer.service.model.Customer;
import com.customer.service.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    CustomerDTO saveCustomer(Customer customer);
    List<CustomerDTO> getCustomers();
}
