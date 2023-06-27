package com.example.application_blog.service;

import com.example.application_blog.model.Blog;
import com.example.application_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> getCategory();

    void deleteCategory(int id);

    void updateCategory(Category category);

    boolean saveCategory(Category category);

    Category viewCategory(int id);

    List<Blog> searchByContent(String content);
    List<Category> getCategories();
    Page<Category> getNameCategory(int id);
}
