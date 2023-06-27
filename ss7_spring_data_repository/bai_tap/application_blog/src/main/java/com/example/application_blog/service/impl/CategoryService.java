package com.example.application_blog.service.impl;

import com.example.application_blog.model.Blog;
import com.example.application_blog.model.Category;
import com.example.application_blog.repository.IBlogRepository;
import com.example.application_blog.repository.ICategoryRepository;
import com.example.application_blog.service.ICategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> getCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void saveCategory(Category category) {
       categoryRepository.save(category);
    }

    @Override
    public Category viewCategory(int id) {
        return null;
    }

    @Override
    public List<Blog> searchByContent(String content) {
        return null;
    }

    @Override
    public List<Category> getCategories() {
        return null;
    }

    @Override
    public Page<Category> getNameCategory(int id) {
        return null;
    }
}
