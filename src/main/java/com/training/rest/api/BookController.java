/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.rest.api;

import java.net.URI;
import java.util.List;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.training.rest.model.Book;
import com.training.rest.service.BookService;
import javax.persistence.EntityNotFoundException;

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
        Book saved = bookService.save(book);
        URI location = MvcUriComponentsBuilder
            .fromMethodCall(
                on(BookController.class)
                .getBook(saved.getId())
            ).build()
            .toUri();
                
        return ResponseEntity
            .created(location)
            .build();
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Book getBook(@PathVariable(value="id") Long id) {
        Book book = bookService.getBook(id);
        if (book == null) {
            throw new EntityNotFoundException("Book not found");
        }
        return book;
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> listBooks() {
        return bookService.listBooks();
    }
}
