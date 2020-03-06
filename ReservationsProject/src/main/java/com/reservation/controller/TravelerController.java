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

import com.reservation.model.Traveler;
import com.reservation.service.TravelerService;

@RestController
@RequestMapping("/traveler")
public class TravelerController {

	@Autowired
	private TravelerService service;

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Traveler>> getAllTraveler() {

		List<Traveler> list = service.getTraveler();
		return ResponseEntity.ok(list);
	}

	@PostMapping(value = "/insertTraveler")
	public ResponseEntity<Traveler> insertTraveler(@RequestBody Traveler request) {

		Traveler trav = service.insertTraveler(request);
		return ResponseEntity.ok(trav);
	}

	
	@GetMapping(value = "/getTravelerById")
	public ResponseEntity<Optional<Traveler>> getTravelerById(@RequestBody Traveler request) {

		Optional<Traveler> stock = service.getById(request);
		if (stock.isPresent()) {
			return ResponseEntity.ok(stock);
		} else {
			return ResponseEntity.ok(null);
		}

	}

	@PostMapping(value = "updateTraveler")
	public ResponseEntity<Traveler> updateTraveler( @RequestBody Traveler request) {
		Optional<Traveler> stock = service.getById(request); 
		if (stock.isPresent()) {
			Traveler traveler = service.insertTraveler(request);
			traveler.setTravelerName(request.getTravelerName());
			traveler.setTravelerSurname(request.getTravelerSurname());
			traveler.setTravelerBirthdate(request.getTravelerBirthdate());
			traveler.setTravelerEmail(request.getTravelerEmail());
			traveler.setPhoneNr(request.getPhoneNr());
			return ResponseEntity.ok(traveler);
		}
		return ResponseEntity.ok(null);
	}
	
	@PostMapping(value = "deleteTraveler")
	public ResponseEntity<?> deleteTraveler(@RequestBody Traveler request){
		
		Optional<Traveler> stock = service.getById(request);
		if(stock.isPresent()) {
			service.deleteTraveler(request);
			return ResponseEntity.ok("Traveler deleted!");
		}
		else {
			return ResponseEntity.ok("Record doesn't exist !");
		}
	}
	
	
	/* Pagination */
	@GetMapping(value = "/getPaged")
	public ResponseEntity<List<Traveler>> getPagedTravelers(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		
		List<Traveler> list = service.getPagedTravelers(pageNo, pageSize);

		return new ResponseEntity<List<Traveler>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	/* Pagination with order*/
	@GetMapping(value = "/getPagedWithOrder")
	public ResponseEntity<List<Traveler>> getPagedTravelers(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id") String sortBy) {
		
		List<Traveler> list = service.getPagedTravelersWithOrder(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<Traveler>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
