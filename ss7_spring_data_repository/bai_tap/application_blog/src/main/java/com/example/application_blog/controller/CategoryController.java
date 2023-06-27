package com.example.application_blog.controller;

import com.example.application_blog.model.Blog;
import com.example.application_blog.model.Category;
import com.example.application_blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.data.domain.Pageable;
import java.time.LocalDate;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showBlogs( Model model) {
        model.addAttribute("categorys",categoryService.getCategory());
        return "/category/view";
    }

    @GetMapping ("/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        if (categoryService.viewCategory(id) != null) {
            redirectAttributes.addFlashAttribute("message", "Bạn đã xóa thành công :");
            categoryService.deleteCategory(id);
        } else {
            redirectAttributes.addFlashAttribute("message", "Bạn thực hiện bị lỗi : Vui lòng thực hiện lại");
        }
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        if (categoryService.viewCategory(id) != null) {
            model.addAttribute("category",categoryService.viewCategory(id));
            return "/category/edit";
        } else {
            redirectAttributes.addFlashAttribute("message", "Bạn thực hiện bị lỗi : Vui lòng thực hiện lại");
            return "redirect:/category";
        }
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Category category, RedirectAttributes redirectAttributes, Model model) {
        if (categoryService.viewCategory(category.getId_category()) != null) {
            categoryService.updateCategory(category);
            redirectAttributes.addFlashAttribute("message", "Bạn đã thay đổi thành công :");
            return "redirect:/category";
        } else {
            model.addAttribute("category", category);
            model.addAttribute("message", "Bạn đã thay đổi không thành công :");
            return "/category/edit";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("category", new Category());
        return "/category/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Category category, Model model, RedirectAttributes redirectAttributes) {
        if (categoryService.saveCategory(category)) {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công :");
            return "redirect:/category";
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm mới không thành công :");
            model.addAttribute("category", category);
            return "/category/create";
        }
    }


    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (categoryService.viewCategory(id) != null) {
            model.addAttribute("blog", categoryService.viewCategory(id));
            return "/category/view";
        } else {
            redirectAttributes.addFlashAttribute("message", "Bạn thực hiện bị lỗi :");
            return "redirect:/category";
        }
    }
}
