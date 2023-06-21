package com.example.manage_product.service.impl;

import com.example.manage_product.model.Product;
import com.example.manage_product.repository.IProductRepository;
import com.example.manage_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public void deleteProduct(int id) {
        productRepository.deleteProduct(id);
    }

    @Override
    public boolean saveProduct(Product product) {
        if (product.getName().equals("") || product.getDetail().equals("") || product.getPrice() == 0.0 || product.getManufacture().equals("")) {
            return false;
        }
        productRepository.createProduct(product);
        return true;
    }

    @Override
    public void editProduct(Product product) {
        products = productRepository.getProducts();
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                p.setName(product.getName());
                p.setPrice(product.getPrice());
                p.setDetail(product.getDetail());
                p.setManufacture(product.getManufacture());
                break;
            }
        }
    }

    @Override
    public Product findProduct(int id) {
        return productRepository.findProduct(id);
    }

    @Override
    public List<Product> searchProducts(String name) {
        return productRepository.searchProduct(name);
    }
}
