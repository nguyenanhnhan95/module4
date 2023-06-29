package com.example.manage_books.serivce;

import com.example.manage_books.model.BookRental;

import java.time.LocalDate;
import java.util.List;

public interface IBookRentalService {
    void saveRentalBorrow(BookRental bookRental);
    List<BookRental> getRentals();
    BookRental getBookRental(int id);
    BookRental getBookCode(String code);

}
