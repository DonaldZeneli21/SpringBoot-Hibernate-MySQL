package com.reservation.controller;

import java.util.List;
import java.util.Optional;

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
		
		if(list.size()>0) {
		return ResponseEntity.ok(list);
	    }
		else {
			return ResponseEntity.ok(null);
		}
	}
	@PostMapping(value = "/insertAirport")
	public ResponseEntity<Airport> insertAirport(@RequestBody Airport request){
		
		Airport airport = service.insertAirport(request);
		
		if(!airport.equals(null)) {
			return ResponseEntity.ok(airport);
		}
		else {
			return ResponseEntity.ok(null);
		}
		
	}
	
	@GetMapping(value = "/getAirportById")
	public ResponseEntity<Optional<Airport>> getAirportById(@RequestBody Airport request){
		
		Optional<Airport> stock = service.getById(request);
		if (stock.isPresent()) {
			return ResponseEntity.ok(stock);
		}
		else {
			return ResponseEntity.ok(null);
		}
		
	}
	

	@PostMapping(value = "updateAirport")
	public ResponseEntity<Airport> updateAirport( @RequestBody Airport request) {
		Optional<Airport> stock = service.getById(request); 
		if (stock.isPresent()) {
			Airport airport = service.insertAirport(request);
			airport.setAirportName(request.getAirportName());
			airport.setMaxFlightInDay(request.getMaxFlightInDay());
			airport.setPeopleCapacity(request.getPeopleCapacity());
			
			return ResponseEntity.ok(airport);
		}
		return ResponseEntity.ok(null);
	}
	
	@PostMapping(value = "deleteAirport")
	public ResponseEntity<?> deleteAirport(@RequestBody Airport request){
		
		Optional<Airport> stock = service.getById(request);
		if(stock.isPresent()) {
			service.deleteAirport(request);
			return ResponseEntity.ok("Airport deleted!");
		}
		else {
			return ResponseEntity.ok("Record doesn't exist !");
		}
	}
}
