package com.example.manage_product.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> products=new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }
    public Map<Product,Integer> getProducts(){
        return products;
    }
    public boolean checkItemInCart(Product product){
        for(Map.Entry<Product,Integer> entry:products.entrySet()){
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }
    public boolean checkItemByIdInCart(Integer id){
        for(Map.Entry<Product,Integer> entry:products.entrySet()){
            if(entry.getKey().getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    private Map.Entry<Product,Integer> selectItemInCart(Product product){
        for(Map.Entry<Product,Integer> entry:products.entrySet()){
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }
    public void addProduct(Product product){
        if(!checkItemInCart(product)){
            products.put(product,1);
        }else {
            Map.Entry<Product,Integer> itemEntry= selectItemInCart(product);
            Integer newQuantity= itemEntry.getValue()+1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public void subProduct(Product product){
        Map.Entry<Product,Integer> itemEntry= selectItemInCart(product);
        if(!itemEntry.getValue().equals(1)){
            Integer newQuantity= itemEntry.getValue()-1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }
    public void deleteProduct(Integer id){
        for (Iterator<Map.Entry<Product, Integer>> iterator = products.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry<Product, Integer> entry = iterator.next();
            if (entry.getKey().getId().equals(id)) {
                iterator.remove();
                break;
            }
        }
    }
    public Integer countProductQuality(){
        Integer productQuality=0;
        for (Map.Entry<Product,Integer> entry:products.entrySet()){
            productQuality+= entry.getValue();
        }
        return productQuality;
    }
    public Float countTotalPayment(){
        float payment=0;
        for (Map.Entry<Product,Integer> entry : products.entrySet()){
            payment+=entry.getKey().getPrice()*(float)entry.getValue();
        }
        return payment;
    }
    public void paymentProduct(){
        products.clear();
    }
}
