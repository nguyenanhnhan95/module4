package com.example.manage_product.repository.impl;

import com.example.manage_product.model.Product;
import com.example.manage_product.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone 14", 150000, "SmartPhone", "Apple"));
        products.add(new Product(2, "Desktop-ieog1lo", 25000000, "Laptop", "Asus"));
        products.add(new Product(3, "FilipHouse", 35000, "House", "Philip"));
    }

    @Override
    public List<Product> getProducts() {
        return products;
    }
}
