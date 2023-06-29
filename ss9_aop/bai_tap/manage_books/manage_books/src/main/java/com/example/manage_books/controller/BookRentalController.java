package com.example.manage_books.controller;

import com.example.manage_books.model.Book;
import com.example.manage_books.model.BookRental;
import com.example.manage_books.serivce.IBookRentalService;
import com.example.manage_books.serivce.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.Random;

@Controller
@RequestMapping("/rental")
public class BookRentalController {
    @Autowired
    private IBookRentalService bookRentalService;
    @Autowired
    private IBookService bookService;

    @GetMapping("")
    public String showRental(Model model) {
        model.addAttribute("rentals", bookRentalService.getRentals());
        return "rental/view";
    }

    @PostMapping("/create")
    public String createRental(@PathParam("id") int id, Model model, RedirectAttributes redirectAttributes) {
        Book book = bookService.getBook(id);
        if (book != null) {
            if (book.getNumberOfBooks() == 0) {
                redirectAttributes.addFlashAttribute("msg", "Sách đã hết ");
                return "redirect:/book";
            }
            book.setNumberOfBooks(book.getNumberOfBooks() - 1);
            Random random = new Random();
            int randomNumber = random.nextInt(100000);
            String codeBorrow = String.format("%05d", randomNumber);
            BookRental bookRental = new BookRental(0, codeBorrow, LocalDate.now(), false, book);
            bookRentalService.saveRentalBorrow(bookRental);
            redirectAttributes.addFlashAttribute("msg", "Bạn đặt thành công ");
            model.addAttribute("rentals", bookRentalService.getRentals());
            return "/rental/view";
        } else {
            model.addAttribute("books", bookService.getBooks());
            redirectAttributes.addFlashAttribute("msg", "Bạn thực hện bị lỗi ");
        }
        return "/rental/view";
    }

    @PostMapping("/return")
    public String returnBook(@RequestParam("codeRental") String code, Model model, RedirectAttributes redirectAttributes) {
        BookRental bookRental = bookRentalService.getBookCode(code.trim());
        if (bookRental != null) {
            Book book = bookService.getBook(bookRental.getBook().getId());
            book.setNumberOfBooks(book.getNumberOfBooks() + 1);
            bookService.updateNumberOfBook(book);
            bookRental.setDelete(true);
            bookRentalService.saveRentalBorrow(bookRental);
            model.addAttribute("rentals", bookRentalService.getRentals());
            model.addAttribute("msg", "Trả sách thành công");
        } else {
            model.addAttribute("msg", "Bạn thực hện bị lỗi ");
            model.addAttribute("rentals", bookRentalService.getRentals());
        }
        return "/rental/view";
    }
}
