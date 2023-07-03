package com.example.application_restful.service;

import com.example.application_restful.model.Blog;
import com.example.application_restful.model.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICategoryService {
    List<Category> getCategory();

    void deleteCategory(int id);

    void updateCategory(Category category);

    boolean saveCategory(Category category);

    Category viewCategory(int id);

    List<Blog> findByIdCategory(int id);
    List<Category> getCategories();
    Page<Category> getNameCategory(int id);
}
