package com.example.application_blog.controller;

import com.example.application_blog.model.Blog;
import com.example.application_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showBlogs(@PageableDefault(size = 2, sort = "days", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
        model.addAttribute("blogs", blogService.getBlogs(pageable));
        model.addAttribute("category", blogService.getCategories());
        return "blog/index";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam("id") int id, RedirectAttributes redirectAttributes) {
        if (blogService.viewBlog(id) != null) {
            redirectAttributes.addFlashAttribute("message", "Bạn đã xóa thành công :");
            blogService.deleteBlog(id);
        } else {
            redirectAttributes.addFlashAttribute("message", "Bạn thực hiện bị lỗi : Vui lòng thực hiện lại");
        }
        return "redirect:/blogs";
    }

    @GetMapping("/edit/{id}")
    public String editBlog(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.viewBlog(id) != null) {
            model.addAttribute("blog", blogService.viewBlog(id));
            model.addAttribute("category", blogService.getCategories());
            return "blog/edit";
        } else {
            redirectAttributes.addFlashAttribute("message", "Bạn thực hiện bị lỗi : Vui lòng thực hiện lại");
            return "redirect:/blogs";
        }
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes, Model model) {
        if (blogService.viewBlog(blog.getId()) != null) {
            blogService.updateBlog(blog);
            redirectAttributes.addFlashAttribute("message", "Bạn đã thay đổi thành công :");
            return "redirect:/blogs";
        } else {
            model.addAttribute("blog", blog);
            model.addAttribute("message", "Bạn đã thay đổi không thành công :");
            return "blog/edit";
        }
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("category", blogService.getCategories());
        return "blog/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Blog blog, Model model, RedirectAttributes redirectAttributes) {
        blog.setDays(LocalDate.now());
        if (blogService.saveBlog(blog)) {
            redirectAttributes.addFlashAttribute("message", "Thêm mới thành công :");
            return "redirect:/blogs";
        } else {
            redirectAttributes.addFlashAttribute("message", "Thêm mới không thành công :");
            model.addAttribute("blog", blog);
            return "blog/create";
        }
    }

    @PostMapping("/search")
    public String search(@RequestParam("content") String content, Pageable pageable, Model model) {
        model.addAttribute("blogs", blogService.searchByContent(content, pageable));
        return "blog/index";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model, RedirectAttributes redirectAttributes) {
        if (blogService.viewBlog(id) != null) {
            model.addAttribute("blog", blogService.viewBlog(id));
            return "blog/view";
        } else {
            redirectAttributes.addFlashAttribute("message", "Bạn thực hiện bị lỗi :");
            return "redirect:/blogs";
        }
    }

    @PostMapping("/select")
    public String selectBlog(@RequestParam("id") int id, Pageable pageable, Model model) {
        model.addAttribute("blogs", blogService.getNameCategory(id, pageable));
        model.addAttribute("category", blogService.getCategories());
        return "blog/index";
    }
}
