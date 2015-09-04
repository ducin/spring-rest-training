/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.rest.api;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.training.rest.model.Book;

/**
 *
 * @author Tomasz.Ducin
 */
@RestController
@RequestMapping("/books")
public class BookController {
    
    @RequestMapping
    public List<Book> listBooks() {
        return Arrays.asList(new Book("Millenium"));
    }
}
