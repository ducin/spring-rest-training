/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.training.rest.api

import spock.lang.Specification
import com.training.rest.model.Book
import com.training.rest.RestSpringApplication
import com.training.rest.service.BookService
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.MockMvc
import org.springframework.web.context.WebApplicationContext

/**
 *
 * @author Tomasz.Ducin
 */
@SpringApplicationConfiguration(classes = RestSpringApplication)
@WebAppConfiguration
class BookControllerSpec extends Specification {
    
    @Autowired
    private WebApplicationContext applicationContext
        
    @Autowired
    private BookService bookService

    private MockMvc mockMvc
    
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build()
        
        bookService.save(new Book("Millenium"))
        bookService.save(new Book("Ukraine"))
    }
    
    def "should return list of books"() {
        given:
            def request = MockMvcRequestBuilders.get('/books')
        when:
            def result = mockMvc.perform(request).andReturn().response
        then:
            result.status == 200
    }
    
}

