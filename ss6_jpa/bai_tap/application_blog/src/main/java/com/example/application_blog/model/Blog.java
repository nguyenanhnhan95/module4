package com.example.application_blog.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "blogs")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private LocalDate days;
    private String people;
    @Column(columnDefinition = "longtext")
    private String content;

    public Blog(int id, String title, LocalDate days, String people, String content) {
        this.id = id;
        this.title = title;
        this.days = days;
        this.people = people;
        this.content = content;
    }

    public Blog() {
    }

    public Blog(String title, LocalDate days, String people, String content) {
        this.title = title;
        this.days = days;
        this.people = people;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
}
