package com.example.manage_product.repository;

import com.example.manage_product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getProducts();

    void createProduct(Product product);

    void deleteProduct(int id);

    Product findProduct(int id);

    void editProduct(Product product);

    List<Product> searchProduct(String name);
}
