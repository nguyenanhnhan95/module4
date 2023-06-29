package com.example.manage_product.controller;

import com.example.manage_product.model.Cart;
import com.example.manage_product.model.Product;
import com.example.manage_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService productService;
    @ModelAttribute("cart")
    public Cart setupCart(){
        return new Cart();
    }
    @GetMapping("/shop")
    private String showShop(Model model){
        model.addAttribute("products",productService.findAll());
        return "shop/home";
    }
    @PostMapping("/add")
    public String addToCart(@ModelAttribute Product product, @ModelAttribute Cart cart) {
        Optional<Product> productOptional = productService.findById(product.getId());
        if (!productOptional.isPresent()) {
            return "/error.404";
        }else {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping";
        }
    }
    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable("id") Integer id,Model model){
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }else {
            Product product = productOptional.get();
            model.addAttribute("product", product);
            return "shop/detail";
        }
    }
}
