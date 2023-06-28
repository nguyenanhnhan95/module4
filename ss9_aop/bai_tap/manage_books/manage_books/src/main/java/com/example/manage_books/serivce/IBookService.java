package com.example.manage_books.serivce;

import com.example.manage_books.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
    void updateNumberOfBook(Book book);
    Book getBook(int id);
}
