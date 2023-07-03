package com.example.application_restful.controller;


import com.example.application_restful.model.Blog;
import com.example.application_restful.model.Category;
import com.example.application_restful.repository.IBlogRepository;
import com.example.application_restful.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IBlogRepository blogRepository;
    @GetMapping()
    public ResponseEntity<List<Category>> getCategories(){
        if(categoryService.getCategory().isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(categoryService.getCategory(),HttpStatus.OK);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<List<Blog>> getBlogs(@PathVariable int id){
        if(blogRepository.findBlogsByCategory_IdCategory(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(blogRepository.findBlogsByCategory_IdCategory(id),HttpStatus.OK);
        }

    }
    @PostMapping("{id}")
    public ResponseEntity<List<Blog>> getBlog(@PathVariable int id){
        if(categoryService.findByIdCategory(id)==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(categoryService.findByIdCategory(id),HttpStatus.OK);
        }

    }
}
