package com.example.manage_product.controller;

import com.example.manage_product.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/shopping")
public class ShoppingController {
    @ModelAttribute("cart")
    public Cart setupCart(){
        return  new Cart();
    }
    @GetMapping("")
    public String showCart (@SessionAttribute("cart") Cart cart, Model model){
        model.addAttribute("cart",cart);
        return "shopping/cart";
    }
}
