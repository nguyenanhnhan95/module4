package com.example.application_restful.controller;

import com.example.application_restful.model.Blog;
import com.example.application_restful.service.IBlogService;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/blog")
@CrossOrigin("*")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping({"/load/{number}"})
    public ResponseEntity<List<Blog>> findAllBlog(@PathVariable("number") int number) {
        if (blogService.getBlogs(number).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogService.getBlogs(number), HttpStatus.OK);
    }
    @GetMapping("/search")
    public ResponseEntity<List<Blog>> getSearch(@PathParam("content") String content){
        if (blogService.searchByContent(content).isEmpty()) {
            return new ResponseEntity<>(blogService.searchByContent(content),HttpStatus.NO_CONTENT);
        } else {
            System.out.println(blogService.searchByContent(content).size());
            return new ResponseEntity<>(blogService.searchByContent(content), HttpStatus.OK);
        }
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
        if (blogService.viewBlog(blog.getId()) == null) {
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
