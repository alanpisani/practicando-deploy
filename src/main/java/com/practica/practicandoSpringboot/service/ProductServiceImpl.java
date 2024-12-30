package com.practica.practicandoSpringboot.service;

import com.practica.practicandoSpringboot.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@ConditionalOnProperty(name = "service.products", havingValue = "listResourceService")
public class ProductServiceImpl implements ProductService{
    private final List<Product> products = new ArrayList<>(List.of(
            new Product(0, 10, "Laptop", 799.99),
            new Product(1, 25, "Smartphone", 499.99),
            new Product(2, 15, "Tablet", 199.99),
            new Product(3, 30, "Smartwatch", 299.99)
    ));

    @Override
    public List<Product> getProducts(){
        return products;
    }



}
