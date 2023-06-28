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
    @Query(value = "UPDATE book_rental set day_return=:day WHERE id=:id",nativeQuery = true)
     void updateReturn(@Param(value ="id") int id, @Param(value = "day")LocalDate localDate);
}
