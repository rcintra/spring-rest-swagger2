package com.rcintra.springrestswagger2.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.rcintra.springrestswagger2.SpringRestSwagger2ApplicationTests;

public class Swagger2DemoRestControllerTest extends SpringRestSwagger2ApplicationTests {

private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		 this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}
	
	@Test
	public void should_GetStudent_When_ValidRequest() throws Exception {
		mockMvc.perform(get("/getStudent/Sajal")				
			   .accept(MediaType.APPLICATION_JSON))
			   .andExpect(status().isOk())
			   .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
			   .andExpect(jsonPath("$.name").value("Sajal"))
			   .andExpect(jsonPath("$.cls").value("IV"))
			   .andExpect(jsonPath("$.country").value("India"));
	}
	
	@Test
	public void should_Return404_When_StudentNotFound() throws Exception {
		/* setup mock */
		mockMvc.perform(get("/getStudent/cintra")				
			   .accept(MediaType.APPLICATION_JSON))
			   .andExpect(status().isNotFound());
	}
}
