/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.rest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Size;

/**
 *
 * @author Tomasz.Ducin
 */
@Entity
public class Book {
    
    @Id
    @GeneratedValue
    private Long id;

    @Size(min=5)
    private String title;

    public Book() {}

    public Book(String title) {
        this.title = title;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }
    
    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
}
