package com.practica.practicandoSpringboot.controllers;

import com.practica.practicandoSpringboot.domain.Customer;
import com.practica.practicandoSpringboot.exception.CustomerNotFoundException;
import com.practica.practicandoSpringboot.service.CustomerServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/clientes")
public class CustomerController {

    final private CustomerServiceImpl customerService = new CustomerServiceImpl();
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Customer>> getCustomers(){

        return ResponseEntity.ok(customerService.getCustomers());
    }
    @RequestMapping(value="{ID}", method = RequestMethod.GET)
    public ResponseEntity<?> getCustomerByID(@PathVariable int ID){
        try {
            Customer customer = customerService.getCustomerByID(ID);
            return ResponseEntity.ok(customer);
        }catch(CustomerNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
    @PostMapping
    public ResponseEntity<?> postCustomer(@RequestBody Customer customer){
        customerService.postCustomer(customer);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{ID}")
                .buildAndExpand(customer.getID())
                .toUri();

        //return ResponseEntity.created(location).build();
        return ResponseEntity.created(location).body(customer);
    }

    @PutMapping("/{ID}")
    public ResponseEntity<?> putCustomerByID(@RequestBody Customer c, @PathVariable int ID){
        try{
            customerService.putCustomerByID(c, ID);
            return ResponseEntity.noContent().build();
        }catch(CustomerNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PatchMapping("/{ID}")
    public ResponseEntity<?> patchCustomerByID(@RequestBody Customer c, @PathVariable int ID) {
        try {
            customerService.patchCustomerByID(c, ID);
            return ResponseEntity.noContent().build();
        }catch (CustomerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @DeleteMapping("/{ID}")
    public ResponseEntity<String> deleteUserByID(@PathVariable int ID){
        try{
            customerService.deleteUserByID(ID);
            return ResponseEntity.noContent().build();
        }catch(CustomerNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
