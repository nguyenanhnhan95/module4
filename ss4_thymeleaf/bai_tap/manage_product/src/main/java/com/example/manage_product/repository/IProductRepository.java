package com.example.manage_product.repository;

import com.example.manage_product.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getProducts();
}
