package com.apicarros;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.apicarros.model.CarroDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
class ApicarrosApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Test
	public void contextLoads() {
	}

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getAllCars() throws Exception {
		MvcResult result = mockMvc.perform(get("http://localhost:8080/api/listCars").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();
		Assertions.assertNotNull(result.getResponse().getContentAsString());
	}
	
	@Test
	public void getAllLogs() throws Exception {
		MvcResult result = mockMvc.perform(get("http://localhost:8080/api/logs").contentType("application/json"))
				.andExpect(status().isOk()).andReturn();
		Assertions.assertNotNull(result.getResponse().getContentAsString());
	}
	
	@Test
	public void postCar() throws Exception {
		CarroDTO c = new CarroDTO();
		c.setAge(2020);
		c.setBrand("Marca");
		c.setPrice("10000");
		c.setTitle("Titulo");
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(c);
		mockMvc.perform(
				post("http://localhost:8080/api/createCar").contentType("application/json").content(requestJson))
				.andExpect(status().isOk());

		
	}

	
	
	

}
