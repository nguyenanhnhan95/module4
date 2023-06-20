package com.example.manage_product.controller;

import com.example.manage_product.model.Product;
import com.example.manage_product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping("")
    public String showListProduct(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "/index";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "Bạn đã xóa thành công");
        return "redirect:/products";
    }

    @GetMapping("/create")
    public String createFormProduct(Model model) {
        model.addAttribute("product", new Product());
        return "/create";
    }

    @PostMapping("/create-form")
    public String save(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.saveProduct(product);
        redirectAttributes.addFlashAttribute("message", "Bạn đã thêm thành công");
        return "redirect:/products";
    }

    @GetMapping("{id}/edit-form")
    public String editFormProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findProduct(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        productService.editProduct(product);
        redirectAttributes.addFlashAttribute("message", "Bạn đã thay đổi thông tin thành công ");
        return "redirect:/products";
    }

    @PostMapping("/search")
    public String search(@RequestParam("nameSearch") String name, Model model) {
        model.addAttribute("products", productService.searchProducts(name.trim()));
        return "/index";
    }
}
