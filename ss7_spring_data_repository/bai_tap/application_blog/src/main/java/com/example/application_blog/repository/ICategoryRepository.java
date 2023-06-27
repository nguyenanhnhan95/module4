package com.example.application_blog.repository;

import com.example.application_blog.model.Blog;
import com.example.application_blog.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "SELECT *From categorys where id_category=:id", nativeQuery = true)
    Category getCategory(@Param(value = "id")int id);
}
