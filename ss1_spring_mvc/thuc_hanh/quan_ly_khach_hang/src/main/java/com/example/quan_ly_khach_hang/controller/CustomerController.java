package com.example.quan_ly_khach_hang.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
public class CustomerController {
    @GetMapping("/customers")
    public String showList(){
        return "customers/list.jsp";
    }
}
