package com.reservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Destination;
import com.reservation.service.DestinationService;

@RestController
@RequestMapping("/destination")
public class DestinationController {

	@Autowired
	DestinationService service;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Destination>> getAllDestination(){
		
		List<Destination> list = service.getDestination();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping(value = "/insertDestination")
	public ResponseEntity<Destination> insertDestination(@RequestBody Destination request){
		
		Destination inserted = service.insertDestination(request);
		return ResponseEntity.ok(inserted);
	}
	
	@GetMapping(value = "/getDestinationById")
	public ResponseEntity<Optional<Destination>> getDestinationById(@RequestBody Destination request) {

		Optional<Destination> stock = service.getById(request);
		if (stock.isPresent()) {
			return ResponseEntity.ok(stock);
		} else {
			return ResponseEntity.ok(null);
		}

	}

	@PostMapping(value = "updateDestination")
	public ResponseEntity<Destination> updateDestination( @RequestBody Destination request) {
		Optional<Destination> stock = service.getById(request); 
		if (stock.isPresent()) {
			Destination destination = service.insertDestination(request);
			destination.setContinent(request.getContinent());
			destination.setCountry(request.getCountry());
			destination.setCity(request.getCity());
			destination.setLocation(request.getLocation());
			
			return ResponseEntity.ok(destination);
		}
		return ResponseEntity.ok(null);
	}
	
	@PostMapping(value = "deleteDestination")
	public ResponseEntity<?> deleteDestination(@RequestBody Destination request){
		
		Optional<Destination> stock = service.getById(request);
		if(stock.isPresent()) {
			service.deleteDestination(request);
			return ResponseEntity.ok("Destination deleted!");
		}
		else {
			return ResponseEntity.ok("Record doesn't exist !");
		}
	}
	
	/* Pagination */
	@GetMapping(value = "/getPaged")
	public ResponseEntity<List<Destination>> getPagedDestination(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		
		List<Destination> list = service.getPagedDestination(pageNo, pageSize);

		return new ResponseEntity<List<Destination>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	/* Pagination with order*/
	@GetMapping(value = "/getPagedWithOrder")
	public ResponseEntity<List<Destination>> getPagedDestination(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id") String sortBy) {
		
		List<Destination> list = service.getPagedDestinationWithOrder(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<Destination>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
