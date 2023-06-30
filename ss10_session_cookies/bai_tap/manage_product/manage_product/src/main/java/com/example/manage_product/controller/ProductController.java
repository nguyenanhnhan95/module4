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
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping("/shop")
    private String showShop(Model model) {
        model.addAttribute("products", productService.findAll());
        return "shop/home";
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") int id, @ModelAttribute Cart cart, @RequestParam("action") String action) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        }
        if (action.equals("add")) {
            cart.addProduct(productOptional.get());
            return "redirect:/shopping";
        }
        if (action.equals("sub")) {
            cart.subProduct(productOptional.get());
            return "redirect:/shopping";
        }

        cart.addProduct(productOptional.get());
        return "redirect:/product/shop";
    }

    @GetMapping("/detail/{id}")
    public String detailProduct(@PathVariable("id") Integer id, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return "/error.404";
        } else {
            Product product = productOptional.get();
            model.addAttribute("product", product);
            return "shop/detail";
        }
    }

    @GetMapping("payment")
    public String paymentOrder(@ModelAttribute Cart cart, Model model) {
        cart.paymentProduct();
        return "redirect:/product/shop";
    }
}
