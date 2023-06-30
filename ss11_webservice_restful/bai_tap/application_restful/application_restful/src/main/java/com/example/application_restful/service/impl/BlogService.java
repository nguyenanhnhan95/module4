package com.example.application_restful.service.impl;

import com.example.application_restful.model.Blog;
import com.example.application_restful.model.Category;
import com.example.application_restful.repository.IBlogRepository;
import com.example.application_restful.repository.ICategoryRepository;
import com.example.application_restful.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Blog> getBlogs() {
        return blogRepository.findAllByFlagDeleteIsFalse();
    }

    @Override
    public void deleteBlog(int id) {
        Blog blog = blogRepository.getBlogByIdAndFlagDeleteFalse(id);
        blog.setFlagDelete(true);
        blogRepository.save(blog);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public boolean saveBlog(Blog blog) {
        if (blog.getPeople().equals("") || blog.getContent().equals("")) {
            return false;
        } else {
            blogRepository.save(blog);
            return true;
        }
    }

    @Override
    public Blog viewBlog(int id) {
        return blogRepository.getBlogByIdAndFlagDeleteFalse(id);
    }

    @Override
    public Page<Blog> searchByContent(String content, Pageable pageable) {
        return blogRepository.searchAllBlog(content, pageable);
    }

    @Override
    public List<Category> getCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Blog> getNameCategory(int id, Pageable pageable) {
        return blogRepository.findAllByCategorise(id, pageable);
    }
}
