package com.practica.practicandoSpringboot.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {

    @GetMapping("/palindrome/{word}")
    public String palindrome(@PathVariable String word){
        return "La palabra " + word + (isPalindrome(word) ? " ES" : " NO ES") + " un palíndromo";
    }

    private boolean isPalindrome(String word){
        String alReves = "";
        for(int i=0;i<word.length();i++){
           alReves = word.charAt(i) + alReves;
        }
        return word.equals(alReves);
    }
}
