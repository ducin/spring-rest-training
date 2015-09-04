/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.rest.service;

import com.training.rest.model.Book;
import com.training.rest.repository.BookRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Tomasz.Ducin
 */
@Service
@Transactional
public class BookService {

    private final BookRepository bookRepository;
    
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Long id, String title) {
        Book book = new Book(title);
        return bookRepository.save(book);
    }

    public Book getBook(Long id) {
        return bookRepository.findOne(id);
    }

    public List<Book> listBooks() {
        return bookRepository.findAll();
    }
}
