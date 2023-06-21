package com.example.manage_product.repository.impl;

import com.example.manage_product.model.Product;
import com.example.manage_product.repository.ConnectionUtils;
import com.example.manage_product.repository.IProductRepository;
;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    private static final String SELECT_ALL_PRODUCT_QUERY = "select p from Product as p";
    private static final String SELECT_SEARCH_PRODUCT_QUERY = "select p from Product as p WHERE p.name like  concat('%',:name,'%') ";
    private static final String DELETE_PRODUCT_QUERY = "DELETE p FROM Product as p WHERE p.id= :id";

    @Override
    public List<Product> getProducts() {
        return ConnectionUtils.getEntityManager().createQuery(SELECT_ALL_PRODUCT_QUERY).getResultList();
    }

    @Override
    public void createProduct(Product product) {
        Session session = null;
        Transaction transactional = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transactional = session.beginTransaction();
            session.save(product);
            transactional.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transactional != null) {
                transactional.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        Session session = null;
        Transaction transactional = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transactional = session.beginTransaction();
            Product product = findProduct(id);
            session.remove(product);
            transactional.commit();
            ConnectionUtils.getEntityManager().clear();
        } catch (Exception e) {
            e.printStackTrace();
            if (transactional != null) {
                transactional.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findProduct(int id) {
        String queryStr = "SELECT p FROM Product AS p WHERE p.id = :id";
        TypedQuery<Product> query = ConnectionUtils.getEntityManager().createQuery(queryStr, Product.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void editProduct(Product product) {
        Session session = null;
        Transaction transactional = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transactional = session.beginTransaction();
            Product productOne = findProduct(product.getId());
            productOne.setName(product.getName());
            productOne.setPrice(product.getPrice());
            productOne.setDetail(product.getDetail());
            productOne.setManufacture(product.getManufacture());
            session.update(productOne);
            transactional.commit();
            ConnectionUtils.getEntityManager().clear();
        } catch (Exception e) {
            e.printStackTrace();
            if (transactional != null) {
                transactional.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> searchProduct(String name) {
        Session session = ConnectionUtils.getSessionFactory().openSession();
        TypedQuery<Product> query = session.createQuery(SELECT_SEARCH_PRODUCT_QUERY);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
