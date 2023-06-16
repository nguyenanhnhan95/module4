package com.example.calculator.controller;

import com.example.calculator.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("")
    public String showFormCalculator() {
        return "show";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String getResult(double numberOne, double numberTwo, String calculate, RedirectAttributes redirectAttributes) {
        String result = calculatorService.getCalculatorResult(numberOne, numberTwo, calculate);
        redirectAttributes.addFlashAttribute("result", result);
        return "redirect:/";
    }
}
