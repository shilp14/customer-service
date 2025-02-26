package com.customer.service.controller;

import com.customer.service.model.Customer;
import com.customer.service.model.CustomerDTO;
import com.customer.service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired

    public CustomerController(CustomerService customerService){
        this.customerService = customerService;

    }

      @PostMapping
     public ResponseEntity<CustomerDTO> create(@RequestBody Customer customer){
        CustomerDTO customerDetails = customerService.saveCustomer(customer);
        return new ResponseEntity<>(customerDetails,HttpStatus.CREATED);
      }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getCustomers(){
        return new ResponseEntity<>(customerService.getCustomers(),HttpStatus.OK);
    }

}
