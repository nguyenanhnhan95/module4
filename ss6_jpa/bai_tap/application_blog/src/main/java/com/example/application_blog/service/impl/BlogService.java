package com.example.application_blog.service.impl;

import com.example.application_blog.model.Blog;
import com.example.application_blog.repository.IBlogRepository;
import com.example.application_blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }

    @Override
    public void deleteBlog(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public boolean saveBlog(Blog blog) {
        if (blog.getPeople().equals("") || blog.getContent().equals("") || blog.getTitle().equals("")) {
            return false;
        } else {
            blogRepository.save(blog);
            return true;
        }
    }

    @Override
    public Blog viewBlog(Integer id) {
        return blogRepository.findById(id).orElse(null);
//        return blogRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Không tìm thấy id " + id));
    }

    @Override
    public List<Blog> searchByName(String name) {
        return blogRepository.searchBlog(name);
    }
}
