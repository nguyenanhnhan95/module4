package com.example.application_restful.controller;

import com.example.application_restful.model.Blog;
import com.example.application_restful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ResponseEntity<List<Blog>> findAllBlog() {
        if (blogService.getBlogs().isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogService.getBlogs(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Blog> getBlogDetail(@PathVariable Integer id) {
        if (blogService.viewBlog(id) != null) {
            return new ResponseEntity<>(blogService.viewBlog(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping()
    public ResponseEntity<?> createBlog(@RequestBody Blog blog) {
        if (blogService.viewBlog(blog.getId()) != null) {
            blogService.saveBlog(blog);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping()
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog) {
        if (blogService.viewBlog(blog.getId()) != null) {
            blogService.updateBlog(blog);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteBlog(@PathVariable int id) {
        if (blogService.viewBlog(id) != null) {
            blogService.deleteBlog(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
