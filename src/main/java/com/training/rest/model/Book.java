/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.training.rest.model;

/**
 *
 * @author Tomasz.Ducin
 */
public class Book {
    
    private final String title;

    public Book(String title) {
        this.title = title;
    }
    
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    
}
