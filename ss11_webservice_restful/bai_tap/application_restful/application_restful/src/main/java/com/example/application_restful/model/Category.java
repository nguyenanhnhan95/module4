package com.example.application_restful.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorys")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCategory;
    private String name_category;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private List<Blog> blogs;

    public Category(int id_category, String name_category, List<Blog> blogs) {
        this.idCategory = id_category;
        this.name_category = name_category;
        this.blogs = blogs;
    }



    public Category() {
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getName_category() {
        return name_category;
    }

    public void setName_category(String name_category) {
        this.name_category = name_category;
    }

}
