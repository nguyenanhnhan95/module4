package com.example.application_restful.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate days;
    private String people;
    @Column(columnDefinition = "longtext")
    private String content;
    private boolean flagDelete =false;
    @ManyToOne
    @JoinColumn(name="id_category",nullable = false)
    private Category category;
    public Blog(int id, String title, LocalDate days, String people, String content, boolean is_delete_blog, Category category) {
        this.id = id;
        this.days = days;
        this.people = people;
        this.content = content;
        this.flagDelete = is_delete_blog;
        this.category = category;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getDays() {
        return days;
    }

    public void setDays(LocalDate days) {
        this.days = days;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
