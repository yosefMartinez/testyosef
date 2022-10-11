package com.test.yosef.example_yosef_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test", produces= MediaType.APPLICATION_JSON_VALUE)
public class SucursalesController {
	
	
	@Autowired
	SucursalesRepository sucursalesRepository;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResponseEntity<String> saveData(@RequestBody Sucursale sucursale){
		

		sucursalesRepository.save(sucursale);
		
		System.out.println("1");
		
		return null;
		
	}
	
	
	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ResponseEntity<Sucursale> getData(){
		
		
		Sucursale sucursale = sucursalesRepository.getById(1);
		
		System.out.println("2");
		
		return ResponseEntity.ok(sucursale);
		
	}
	
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<String> updateData(@RequestBody Sucursale sucursale){
		
		
	 sucursalesRepository.save(sucursale);
		
		System.out.println("3");
		
		return null;
		
	}
	
	
}
