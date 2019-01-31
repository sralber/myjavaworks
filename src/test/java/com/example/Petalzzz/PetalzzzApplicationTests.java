package com.example.Petalzzz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.petalzzz.api.controller.PetalzzzController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PetalzzzController.class)
@WebAppConfiguration
public class PetalzzzApplicationTests {
	   protected MockMvc mvc;
	   @Autowired
	   WebApplicationContext webApplicationContext;
	   protected void setUp() {
		      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		   }
	@Test
	public void getUsers() throws Exception {
		
		String uri = "/getUsers";
		   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
		      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
		   int status = mvcResult.getResponse().getStatus();
		   assertEquals(200, status);
	}



}

