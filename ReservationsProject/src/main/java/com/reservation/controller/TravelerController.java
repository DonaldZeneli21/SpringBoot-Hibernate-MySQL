package com.reservation.controller;

import java.util.List;

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
	public ResponseEntity<List<Traveler>> getAllTravelers(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id") String sortBy) {
		
		List<Traveler> list = service.getPagedTravelersWithOrder(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<Traveler>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
