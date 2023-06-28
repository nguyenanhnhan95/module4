package com.example.manage_books.repository;

import com.example.manage_books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book,Integer> {
    List<Book> findAllByFlagDeleteIsFalse();
    Book getBookByIdAndFlagDeleteFalse(int id);
}
