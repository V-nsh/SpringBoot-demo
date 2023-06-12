package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.entity.Customer;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(String id){
        return customerRepository.findById(id);
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(String id){
        customerRepository.deleteById(id);
    }

    public Optional<Customer> updateCustomer(Customer customer, String id) {
        Optional<Customer> existingCustomer = this.getCustomerById(id);
        if(existingCustomer.isPresent()) {
            existingCustomer.get().setName(customer.getName());
            existingCustomer.get().setEmail(customer.getEmail());
            existingCustomer.get().setPassword(customer.getPassword());
            existingCustomer.get().setProductIds(customer.getProductIds());

            customerRepository.save(existingCustomer.get());
            return existingCustomer;
        }
        return existingCustomer;
    }
}
