package com.example.application_restful.repository;

import com.example.application_restful.model.Blog;
import com.example.application_restful.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value = "SELECT *From categorys where id_category=:id", nativeQuery = true)
    Category getCategory(@Param(value = "id")int id);

    Category findByidCategory(int id);

}
