package com.practica.practicandoSpringboot.domain;

public class Product {
    private Integer ID, stock;
    String name;
    Double price;

    public Product(Integer ID, Integer stock, String name, Double price) {
        this.ID = ID;
        this.stock = stock;
        this.name = name;
        this.price = price;
    }
    public Product(){ //Jackson necesita de un constructor vacío para deserializar

    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
