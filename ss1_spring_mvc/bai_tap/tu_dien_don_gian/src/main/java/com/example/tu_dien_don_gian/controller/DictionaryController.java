package com.example.tu_dien_don_gian.controller;

import com.example.tu_dien_don_gian.service.impl.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("")
    public String showFormDictionary() {
        return "index";
    }

    @PostMapping("/search")
    public String dictionary(@RequestParam String english, Model model) {
        model.addAttribute("result", dictionaryService.getResult(english));
        return "index";
    }
}
