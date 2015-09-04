/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.rest.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.training.rest.model.Book;
import com.training.rest.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author Tomasz.Ducin
 */
@RestController
public class BookController {
    
    private final BookService bookService;
    
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<Void> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .build();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Book getBook(@PathVariable(value="id") Long id) {
        return bookService.getBook(id);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> listBooks() {
        return bookService.listBooks();
    }
}
