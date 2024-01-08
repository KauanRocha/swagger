package br.com.estudos.swagger.controllers;

import br.com.estudos.swagger.exceptions.BookNotFoundException;
import br.com.estudos.swagger.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/{id}")
    public br.com.estudos.swagger.models.Book findById(@PathVariable Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("book-not-found"));
    }

    @GetMapping("/")
    public List<br.com.estudos.swagger.models.Book> findBooks() {
        return bookRepository.findAll();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(
            @PathVariable("id") final String id, @RequestBody final Book book) {
        return book;
    }
}
