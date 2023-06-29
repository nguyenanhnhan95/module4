package com.example.manage_books.serivce.impl;

import com.example.manage_books.model.BookRental;
import com.example.manage_books.repository.IBookRentalRepository;
import com.example.manage_books.serivce.IBookRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BookRentalService implements IBookRentalService {
    @Autowired
    private IBookRentalRepository bookRentalRepository;
    @Override
    public void saveRentalBorrow(BookRental bookRental) {
         bookRentalRepository.save(bookRental);
    }

    @Override
    public List<BookRental> getRentals() {
        return bookRentalRepository.findByisDeleteIsFalse();
    }

    @Override
    public BookRental getBookRental(int id) {
        return bookRentalRepository.getBookRental(id);
    }

    @Override
    public BookRental getBookCode(String code) {
        return bookRentalRepository.getBookCode(code);
    }


}
