package com.example.manage_product.service;

import com.example.manage_product.model.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Integer id);
}
