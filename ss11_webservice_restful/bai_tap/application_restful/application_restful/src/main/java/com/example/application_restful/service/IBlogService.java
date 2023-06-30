package com.example.application_restful.service;

import com.example.application_restful.model.Blog;
import com.example.application_restful.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> getBlogs();

    void deleteBlog(int id);

    void updateBlog(Blog blog);

    boolean saveBlog(Blog blog);

    Blog viewBlog(int id);

    Page<Blog> searchByContent(String content, Pageable pageable);

    List<Category> getCategories();

    Page<Blog> getNameCategory(int id, Pageable pageable);
}
