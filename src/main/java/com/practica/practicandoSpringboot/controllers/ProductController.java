package com.practica.practicandoSpringboot.controllers;

import com.practica.practicandoSpringboot.configurations.ExternalizedConfigurations;
import com.practica.practicandoSpringboot.domain.Product;
import com.practica.practicandoSpringboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductController {
    @Autowired
    @Lazy
    private ProductService productService;
    @Autowired
    private ExternalizedConfigurations externalizedConfigurations;
    @GetMapping
    public ResponseEntity<?> getProducts(){
        System.out.println(externalizedConfigurations);
        List<Product> products = productService.getProducts();
        return ResponseEntity.ok(products);
    }
}
