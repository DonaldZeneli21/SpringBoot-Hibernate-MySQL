package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Airport;
import com.reservation.service.AirportService;

@RestController
@RequestMapping("/airport")
public class AirportController {

	@Autowired
	private AirportService service;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Airport>> getAllAirport(){
		
		List<Airport> list = service.getAirport();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping(value = "/insertAirport")
	public ResponseEntity<Airport> insertAirport(@RequestBody Airport request){
		
		Airport airport = service.insertAirport(request);
		return ResponseEntity.ok(airport);
	}
	
}
