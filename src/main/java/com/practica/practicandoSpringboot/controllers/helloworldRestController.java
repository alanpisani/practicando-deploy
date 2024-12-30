package com.practica.practicandoSpringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloworldRestController {

    @GetMapping({"/hello", "/hw", "/hola"})
    public String helloworld(){

        return "Hello world";
    }

}
