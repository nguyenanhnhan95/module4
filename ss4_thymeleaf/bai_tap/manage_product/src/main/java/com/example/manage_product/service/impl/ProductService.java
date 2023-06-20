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
    private List<Product> products;

    @Override
    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    @Override
    public void deleteProduct(int id) {
        products = productRepository.getProducts();
        int size = products.size();
        for (int i = 0; i < size; i++) {
            if (products.get(i).getId() == id) {
                products.remove(i);
                break;
            }
        }
    }

    @Override
    public void saveProduct(Product product) {
        products = productRepository.getProducts();
        int idNew = products.size() + 1;
        products.add(new Product(idNew, product.getName(), product.getPrice(), product.getDetail(), product.getManufacture()));
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
        products = productRepository.getProducts();
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> searchProducts(String name) {
        List<Product> searchProducts = new ArrayList<>();
        products = productRepository.getProducts();
        for (Product p : products) {
            if (p.getName().contains(name)) {
                searchProducts.add(p);
            }
        }
        return searchProducts;
    }
}
