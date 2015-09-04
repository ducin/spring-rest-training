/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.training.rest.api

import com.training.rest.RestSpringApplication
import org.springframework.web.context.WebApplicationContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.MockMvc

/**
 *
 * @author Tomasz.Ducin
 */
@SpringApplicationConfiguration(classes = RestSpringApplication)
@WebAppConfiguration
class AbstractControllerSpec {

    @Autowired
    protected WebApplicationContext applicationContext
        
    protected MockMvc mockMvc
    
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build()
    }
}

