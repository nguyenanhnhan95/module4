package com.example.manage_books.controller;

import com.example.manage_books.serivce.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService bookService;
    @GetMapping("")
    public String showBook(Model model){
        model.addAttribute("books",bookService.getBooks());
        return "book/view";
    }
    @GetMapping("/detail/{id}")
    public String showDetailBook(@PathVariable("id") int id, Model model){
        model.addAttribute("book",bookService.getBook(id));
        return "book/detail";
    }
}
