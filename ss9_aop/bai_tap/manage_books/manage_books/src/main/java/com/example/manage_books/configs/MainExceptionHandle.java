package com.example.manage_books.configs;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class MainExceptionHandle {
    @ExceptionHandler(Exception.class)
    public String get500Page(Exception ex, Model model){
        model.addAttribute("error",ex.getMessage());
        return "/500";
    }
}
