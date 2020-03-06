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
	
	@GetMapping(value = "/getReservationnById")
	public ResponseEntity<Optional<Reservation>> getReservationById(@RequestBody Reservation request) {

		Optional<Reservation> stock = service.getById(request);
		if (stock.isPresent()) {
			return ResponseEntity.ok(stock);
		} else {
			return ResponseEntity.ok(null);
		}

	}

	@PostMapping(value = "updateReservation")
	public ResponseEntity<Reservation> updateReservation( @RequestBody Reservation request) {
		Optional<Reservation> stock = service.getById(request); 
		if (stock.isPresent()) {
			Reservation res = service.insertReservation(request);
			res.setReservationDate(request.getReservationDate());
			res.setCanceled(request.isCanceled());
			res.setCancelDate(request.getCancelDate());
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.ok(null);
	}
	
	@PostMapping(value = "deleteReservation")
	public ResponseEntity<?> deleteReservation(@RequestBody Reservation request){
		
		Optional<Reservation> stock = service.getById(request);
		if(stock.isPresent()) {
			service.deleteReservation(request);
			return ResponseEntity.ok("Reservation deleted!");
		}
		else {
			return ResponseEntity.ok("Record doesn't exist !");
		}
	}
}
