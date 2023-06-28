package com.example.manage_books.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class BookRental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idReturn;
    private String codeBorrow;


    private LocalDate dayReturn;
    private boolean isDelete=false;
    @ManyToOne()
    @JoinColumn(name="id",nullable = false)
    private Book book;
    public BookRental() {
    }

    public BookRental(int idReturn, String codeBorrow, LocalDate dayReturn, boolean isDelete, Book book) {
        this.idReturn = idReturn;
        this.codeBorrow = codeBorrow;
        this.dayReturn = dayReturn;
        this.isDelete = isDelete;
        this.book = book;
    }

    public int getIdReturn() {
        return idReturn;
    }

    public void setIdReturn(int idReturn) {
        this.idReturn = idReturn;
    }

    public String getCodeBorrow() {
        return codeBorrow;
    }

    public void setCodeBorrow(String codeBorrow) {
        this.codeBorrow = codeBorrow;
    }

    public LocalDate getDayReturn() {
        return dayReturn;
    }

    public void setDayReturn(LocalDate dayReturn) {
        this.dayReturn = dayReturn;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
