package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@CrossOrigin

public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    @CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
    public ResponseEntity<?> getCustomers() {
        return ResponseEntity.ok(customerService.getCustomers());
    }

    @GetMapping("/{id}")
    @CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
    public ResponseEntity<?> getCustomerById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @PostMapping
    @CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @DeleteMapping("/{id}")
    @CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.ok("Customer deleted");
    }

    @PutMapping("/{id}")
    @CrossOrigin(exposedHeaders = "Access-Control-Allow-Origin")
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long id) {
        return ResponseEntity.ok(customerService.updateCustomer(customer, id));
    }
}
