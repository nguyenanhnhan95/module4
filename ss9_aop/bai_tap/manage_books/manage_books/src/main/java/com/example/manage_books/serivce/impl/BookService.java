package com.example.manage_books.serivce.impl;

import com.example.manage_books.model.Book;
import com.example.manage_books.repository.IBookRepository;
import com.example.manage_books.serivce.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;
    @Override
    public List<Book> getBooks() {
        return bookRepository.findAllByFlagDeleteIsFalse();
    }

    @Override
    public void updateNumberOfBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book getBook(int id) {
        return bookRepository.getBookByIdAndFlagDeleteFalse(id);
    }
}
