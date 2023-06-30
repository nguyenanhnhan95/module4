package com.example.manage_product.controller;

import com.example.manage_product.model.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id")Integer id,@SessionAttribute("cart") Cart cart,Model model){
        if(cart.checkItemByIdInCart(id)){
            cart.deleteProduct(id);
        }
        model.addAttribute("cart",cart);
        return "shopping/cart";
    }
}
