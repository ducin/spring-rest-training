/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.training.rest.api

import spock.lang.Specification
import com.training.rest.model.Book
import com.training.rest.service.BookService
import groovy.json.JsonSlurper
import org.springframework.beans.factory.annotation.Autowired

/**
 *
 * @author Tomasz.Ducin
 */
class BookControllerSpec extends AbstractControllerSpec {
    
    @Autowired
    private BookService bookService

    void setup() {
        bookService.save(new Book("Millenium"))
        bookService.save(new Book("Ukraine"))
    }
    
    def "should return list of books"() {
        given:
            def request = MockMvcRequestBuilders.get('/books')
        when:
            def response = mockMvc.perform(request).andReturn().response
        then:
            response.status == 200
        and:
            def json = new JsonSlurper().parseText(response.contentAsString)
            json.size == 2
            json.title == ["Millenium", "Ukraine"]
        println json
    }
    
}

