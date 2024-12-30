package com.practica.practicandoSpringboot.service;

import com.practica.practicandoSpringboot.domain.Customer;
import com.practica.practicandoSpringboot.exception.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CustomerServiceImpl{

    private final List<Customer> customers = new ArrayList<>(Arrays.asList(
            new Customer(0, "Alan", "shiterios", "123456"),
            new Customer(1, "Ezequiel", "mordecai", "123456"),
            new Customer(2, "Red", "Icarus", "456789"),
            new Customer(3, "Daiana", "Drummerbass", "coshita")
    ));
    public List<Customer> getCustomers(){
        return customers;
    }
    public Customer getCustomerByID(int ID){
        for (Customer customer : customers) {
            if (customer.getID() == ID) {
                return customers.get(ID);
            }
        }
        throw new CustomerNotFoundException("No se encontró ningún cliente con el ID: " + ID);
    }

    public void postCustomer(Customer customer){

        customers.add(customer);
    }

    public void putCustomerByID(Customer c, int ID){
        for(Customer customer : customers) {
            if (customer.getID() == ID) {
                c.setID(customer.getID()); //TODO por ahora dejarlo asi
                customers.set(customers.indexOf(customer), c);
                return;
            }
        }
        throw new CustomerNotFoundException("No se encontró ningún cliente con el ID: " + ID);
    }

    public void patchCustomerByID(Customer c, int ID) {
        for (Customer customer : customers) {
            if (customer.getID() == ID) {
                if (c.getName() != null) customer.setName(c.getName());
                if (c.getUsername() != null) customer.setUsername(c.getUsername());
                if (c.getPassword() != null) customer.setPassword(c.getPassword());

                customers.set(customers.indexOf(customer), customer);
                return;
            }
        }
        throw new CustomerNotFoundException("No se encontró ningún cliente con el ID: " + ID);

    }

    public void deleteUserByID(@PathVariable int ID){

        for(Customer customer : customers) {
            if(customer.getID() == ID){
                String nombreUsuarioBorrado = customer.getUsername();
                customers.remove(customer);
                return;
            }
        }
        throw new CustomerNotFoundException("No se encontró ningún cliente con el ID: " + ID);

    }
}
