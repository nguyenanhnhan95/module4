package com.example.spices_sandwich.controller;

import com.example.spices_sandwich.service.impl.SandwichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

@Controller
public class SandwichController {
    @Autowired
    private SandwichService sandwichService;

    @GetMapping("")
    public String showFromChoice() {
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam(name = "condiment", required = false, defaultValue = "") String[] condiment, RedirectAttributes redirectAttributes, Model model) {
        String result = sandwichService.checkChoice(condiment);
        if (result.equals("")) {
            model.addAttribute("list", condiment);
            return "list";
        }
        redirectAttributes.addFlashAttribute("choice", result);
        return "redirect:/";
    }
}
