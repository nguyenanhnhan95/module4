package com.example.application_blog.service;

import com.example.application_blog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> getBlogs();

    void deleteBlog(int id);

    void updateBlog(Blog blog);

    boolean saveBlog(Blog blog);

    Blog viewBlog(Integer id);

    List<Blog> searchByName(String name);
}
