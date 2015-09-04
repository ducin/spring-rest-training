/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.training.rest.model.Book;

/**
 *
 * @author Tomasz.Ducin
 */
public interface BookRepository extends JpaRepository<Book, Long> {
    
}
