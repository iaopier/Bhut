package com.apicarros.controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.apicarros.model.CarroDTO;
import com.apicarros.model.DAOLog;
import com.apicarros.service.LogService;

@RestController
@RequestMapping("/api/")
public class CarrosController {

	@Autowired
	LogService logService;
	
	@RequestMapping(value = "/listCars", method = RequestMethod.GET)
	public ResponseEntity<?> listCars() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<CarroDTO[]> response = restTemplate.getForEntity(
				"http://157.230.213.199:3000/api/cars",
				CarroDTO[].class);
		
		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);	
	}	
	
	@RequestMapping(value = "/createCar", method = RequestMethod.POST)
	public ResponseEntity<?> createCar(@Valid @RequestBody CarroDTO carro){
		RestTemplate restTemplate = new RestTemplate();
		// create headers
	    HttpHeaders headers = new HttpHeaders();
	    // set `content-type` header
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    // set `accept` header
	    headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

	    // create a map for post parameters
	    Map<String, Object> map = new HashMap<>();
	    map.put("title", carro.getTitle());
	    map.put("brand", carro.getBrand());
	    map.put("age", carro.getAge());
	    map.put("price", carro.getPrice());

	    // build the request
	    HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);
		ResponseEntity<CarroDTO> response = restTemplate.postForEntity(
				"http://157.230.213.199:3000/api/cars",entity,
				CarroDTO.class);
		
		DAOLog l = new DAOLog();
		l.setCar_id(response.getBody().get_id());
		logService.save(l);
		
		return new ResponseEntity<>(response.getBody(), HttpStatus.OK);	
		
	}
	
	@RequestMapping(value = "/logs", method = RequestMethod.GET)
	public ResponseEntity<?> logsGet() {
		return new ResponseEntity<>(logService.findAll(), HttpStatus.OK);	
	}
	
}
