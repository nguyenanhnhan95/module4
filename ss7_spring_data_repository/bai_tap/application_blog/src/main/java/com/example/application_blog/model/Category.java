package com.example.application_blog.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id_category;
    private String name_category;

    @OneToMany(mappedBy = "category")
    private List<Blog> blogs;

    public Category(int id_category, String name_category, List<Blog> blogs) {
        this.id_category = id_category;
        this.name_category = name_category;
        this.blogs = blogs;
    }

    public Category() {
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
