package com.example.manage_product.model;

public class Product {
    private int id;
    private String name;
    private double price;
    private String detail;
    private String manufacture;

    public Product(int id, String name, double price, String detail, String manufacture) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.manufacture = manufacture;
    }

    public Product(String name, double price, String detail, String manufacture) {
        this.name = name;
        this.price = price;
        this.detail = detail;
        this.manufacture = manufacture;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }
}
