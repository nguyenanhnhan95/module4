package com.example.application_blog.repository;

import com.example.application_blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "SELECT *From blogs as b WHERE (b.title) LIKE concat('%',:title,'%')", nativeQuery = true)
    List<Blog> searchBlog(@Param(value = "title") String title);
}
