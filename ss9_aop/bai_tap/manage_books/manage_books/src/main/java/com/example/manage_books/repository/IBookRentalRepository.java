package com.example.manage_books.repository;

import com.example.manage_books.model.BookRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IBookRentalRepository extends JpaRepository<BookRental,Integer> {
    List<BookRental> findByisDeleteIsFalse();
    @Query(value = "SELECT *From book_rental where id_return=:id",nativeQuery = true)
    BookRental getBookRental(@Param(value = "id")int id);

    @Query(value = "SELECT *From book_rental where code_borrow=:code",nativeQuery = true)
    BookRental getBookCode(@Param(value = "code")String code);
}
