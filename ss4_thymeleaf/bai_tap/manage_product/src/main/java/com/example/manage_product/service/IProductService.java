package com.example.manage_product.service;

import com.example.manage_product.model.Product;


import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    void deleteProduct(int id);

    boolean saveProduct(Product product);

    void editProduct(Product product);

    Product findProduct(int id);

    List<Product> searchProducts(String name);
}
