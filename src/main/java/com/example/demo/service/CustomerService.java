package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.example.demo.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

import com.example.demo.entity.Customer;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> getCustomers(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        Optional<Customer> customer = customerRepository.findById(id);
        if(!customer.isPresent()) {
            throw new RuntimeException("Customer not found");
        }
        return customer.get();
    }

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id){
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Customer customer, Long id) {
        Customer existingCustomer = getCustomerById(id);
        BeanUtils.copyProperties(customer, existingCustomer, "id");
        Customer updatedCustomer = customerRepository.save(existingCustomer);
        return updatedCustomer;
    }

    public Customer getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
