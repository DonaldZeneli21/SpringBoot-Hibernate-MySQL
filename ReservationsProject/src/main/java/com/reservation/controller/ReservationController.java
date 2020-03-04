package com.reservation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Reservation;
import com.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService service;
	
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Reservation>> getAllReservation(){
		
		List<Reservation> list = service.getReservation();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping(value = "/insertReservation")
	public ResponseEntity<Reservation> insertReservation(@RequestBody Reservation request){
		
		Reservation res = service.insertReservation(request);
		return ResponseEntity.ok(res);
	}
}
