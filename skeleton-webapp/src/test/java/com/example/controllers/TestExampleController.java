package com.example.controllers;

import org.hamcrest.Matcher;
import org.hamcrest.core.StringContains;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class TestExampleController {
	
	@Autowired
	protected WebApplicationContext wac;
	private MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		// Set up a mock MVC tester based on the web application context
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void expectHello() throws Exception{
		Matcher<String> matcher = new StringContains("junit");
		
		mockMvc.perform(get("/demo/hello/junit"))
			.andExpect(status().isOk())
			.andExpect(MockMvcResultMatchers.content().string(matcher));

	}
	
	
	
}
