package com.example.application_restful.service.impl;

import com.example.application_restful.model.Blog;
import com.example.application_restful.model.Category;
import com.example.application_restful.repository.ICategoryRepository;
import com.example.application_restful.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
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
    public boolean saveCategory(Category category) {
        if (category.getName_category().equals("")) {
            return false;
        }
        categoryRepository.save(category);
        return true;
    }

    @Override
    public Category viewCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    @Override
    public List<Blog> findByIdCategory(int id) {
        return categoryRepository.findByidCategory(id).getBlogs();
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
