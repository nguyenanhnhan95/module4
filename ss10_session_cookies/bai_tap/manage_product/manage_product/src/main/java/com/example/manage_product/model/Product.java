package com.example.manage_product.model;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String codeProduct;
    @Column(columnDefinition = "longtext", nullable = false)
    private String img;
    private String nameProduct;
    private double price;
    @Column(columnDefinition = "longtext", nullable = false)
    private String descriptionProduct;

    public Product() {
    }

    public Product(int id, String codeProduct, String img, String nameProduct, double price, String descriptionProduct) {
        this.id = id;
        this.codeProduct = codeProduct;
        this.img = img;
        this.nameProduct = nameProduct;
        this.price = price;
        this.descriptionProduct = descriptionProduct;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescriptionProduct() {
        return descriptionProduct;
    }

    public void setDescriptionProduct(String descriptionProduct) {
        this.descriptionProduct = descriptionProduct;
    }
}
