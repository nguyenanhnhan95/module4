package com.example.manage_books.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  int id;
    private LocalDate dayBorrow;
    private String nameBook;
    private int numberOfBooks;
    @Column(columnDefinition = "longtext", nullable = false)
    private String detailBook;

    private String author;
    private boolean flagDelete=false;
    @OneToMany(mappedBy = "book")
    private List<BookRental> codeReturns;

    public Book() {
    }

    public Book(int id, LocalDate dayBorrow, String nameBook, int numberOfBooks, String detailBook, String author, boolean flagDelete, List<BookRental> codeReturns) {
        this.id = id;
        this.dayBorrow = dayBorrow;
        this.nameBook = nameBook;
        this.numberOfBooks = numberOfBooks;
        this.detailBook = detailBook;
        this.author = author;
        this.flagDelete = flagDelete;
        this.codeReturns = codeReturns;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDayBorrow() {
        return dayBorrow;
    }

    public void setDayBorrow(LocalDate dayBorrow) {
        this.dayBorrow = dayBorrow;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public int getNumberOfBooks() {
        return numberOfBooks;
    }

    public void setNumberOfBooks(int numberOfBooks) {
        this.numberOfBooks = numberOfBooks;
    }

    public String getDetailBook() {
        return detailBook;
    }

    public void setDetailBook(String detailBook) {
        this.detailBook = detailBook;
    }

    public boolean isFlagDelete() {
        return flagDelete;
    }

    public void setFlagDelete(boolean flagDelete) {
        this.flagDelete = flagDelete;
    }

    public List<BookRental> getCodeReturns() {
        return codeReturns;
    }

    public void setCodeReturns(List<BookRental> codeReturns) {
        this.codeReturns = codeReturns;
    }
}
