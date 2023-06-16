package com.example.spices_sandwich.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ControllerSandWich {
    @GetMapping("")
    public String showFromChoice() {
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("list", condiment);
        return "list";
    }
}
