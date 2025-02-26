package com.customer.service.service;

import com.customer.service.dao.CustomerRepository;
import com.customer.service.model.Customer;
import com.customer.service.model.CustomerDTO;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerServiceImpl implements  CustomerService{

     private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDTO saveCustomer(Customer customer) {
        com.customer.service.Entity.Customer customerEntity = customerRepository.save(com.customer.service.Entity.Customer.builder().firstName(customer.getFirstName()).lastName(customer.getLastName()).dateOfBirth(customer.getDateOfBirth()).build());
         return CustomerDTO.builder().id(String.valueOf(customerEntity.getId())).firstName(customerEntity.getFirstName()).lastName(customerEntity.getLastName()).dateOfBirth(customerEntity.getDateOfBirth()).build();
    }

    @Override
    public List<CustomerDTO> getCustomers() {
        return customerRepository.findAll()
                .stream()
                .map(customer -> CustomerDTO.builder().id(String.valueOf(customer.getId())).firstName(customer.getFirstName()).lastName(customer.getLastName()).dateOfBirth(customer.getDateOfBirth()).build())
                .toList();
    }

}
