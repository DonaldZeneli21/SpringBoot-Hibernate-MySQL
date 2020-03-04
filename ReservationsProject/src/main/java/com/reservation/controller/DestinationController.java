package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Destination;
import com.reservation.service.DestinationService;

@RestController
@RequestMapping("/destination")
public class DestinationController {

	@Autowired
	DestinationService service;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Destination>> getDestination(){
		
		List<Destination> list = service.getDestination();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping(value = "/insertDest")
	public ResponseEntity<Destination> save(@RequestBody Destination request){
		
		Destination inserted = service.insertDestination(request);
		return ResponseEntity.ok(inserted);
	}
}
