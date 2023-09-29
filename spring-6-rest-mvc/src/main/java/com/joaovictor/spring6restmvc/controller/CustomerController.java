package com.joaovictor.spring6restmvc.controller;

import com.joaovictor.spring6restmvc.model.Customer;
import com.joaovictor.spring6restmvc.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PatchMapping("{id}")
    public ResponseEntity updateCustomerPatchById(@PathVariable("id") UUID customerId, @RequestBody Customer customer) {
        customerService.upatchCustomerById(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable("id") UUID customerId) {
        customerService.deleteById(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping("{id}")
    public ResponseEntity updateById(@PathVariable("id") UUID customerId, @RequestBody Customer customer) {
        customerService.updateCustomer(customerId, customer);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody Customer customer) {
        Customer savedCustomer = customerService.saveNewCustomer(customer);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/customer/" + savedCustomer.getId().toString());

        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Customer> listCustomers() {
        return customerService.listCustomers();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Customer getCustomerById(@PathVariable("id") UUID id) {
        return customerService.getCustomerById(id);
    }

}
