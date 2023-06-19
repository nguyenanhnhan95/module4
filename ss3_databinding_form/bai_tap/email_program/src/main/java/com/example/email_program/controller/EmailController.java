package com.example.email_program.controller;

import com.example.email_program.model.Email;
import com.example.email_program.service.impl.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("")
    public String showFormEmail(Model model) {
        model.addAttribute("email", this.emailService.getEmail());
        model.addAttribute("languages", emailService.getLanguage());
        model.addAttribute("sizes", emailService.getSize());
        return "email/show";
    }

    @PostMapping("/sitting")
    public String showEmail(Model model) {
        model.addAttribute("email", this.emailService.getEmail());
        model.addAttribute("languages", emailService.getLanguage());
        model.addAttribute("sizes", emailService.getSize());
        return "email/edit";
    }

    @PostMapping("/edit")
    public String editEmail(@ModelAttribute Email email, Model model) {
        this.emailService.editEmails(email);
        return "redirect:/";
    }
}
