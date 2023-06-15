package com.example.chyen_doi_tien_te.controller;

import com.example.chyen_doi_tien_te.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("")
    public String index() {
        return "index";
    }

    @PostMapping("/transfer")
    public String transferVND(@RequestParam Double usd, Model model) {
        model.addAttribute("result", calculatorService.getResult(usd));
        return "index";
    }
}
