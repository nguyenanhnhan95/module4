package com.example.application_restful.repository;

import com.example.application_restful.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findAllByFlagDeleteIsFalse();
    Blog getBlogByIdAndFlagDeleteFalse(int id);
    @Query(value = "SELECT *From blogs as b WHERE b.id_category=:name AND flag_delete=0 ", nativeQuery = true)
    Page<Blog> findAllByCategorise(@Param(value = "name")int id,Pageable pageable);
    @Query(value = "SELECT *From blogs as b WHERE b.content LIKE concat('%',:content,'%') AND flag_delete=0", nativeQuery = true)
    Page<Blog> searchAllBlog(@Param(value = "content") String content,Pageable pageable);
    List<Blog> findBlogsByCategory_IdCategory(int id);
}
