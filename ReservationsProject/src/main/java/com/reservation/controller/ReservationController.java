package com.reservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Reservation;
import com.reservation.service.ReservationService;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

	@Autowired
	private ReservationService service;
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Reservation>> getAllReservation(){
		
		List<Reservation> list = service.getReservation();
		return ResponseEntity.ok(list);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(value = "/insertReservation")
	public ResponseEntity<Reservation> insertReservation(@RequestBody Reservation request){
		
		Reservation res = service.insertReservation(request);
		return ResponseEntity.ok(res);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/getReservationnById")
	public ResponseEntity<Optional<Reservation>> getReservationById(@RequestBody Reservation request) {

		Optional<Reservation> stock = service.getById(request);
		if (stock.isPresent()) {
			return ResponseEntity.ok(stock);
		} else {
			return ResponseEntity.ok(null);
		}

	}

	@PreAuthorize("hasRole('ADMIN')")
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
	
	@PreAuthorize("hasRole('ADMIN')")
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
	
	/* Pagination */
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/getPaged")
	public ResponseEntity<List<Reservation>> getPagedReservation(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {
		
		List<Reservation> list = service.getPagedReservation(pageNo, pageSize);

		return new ResponseEntity<List<Reservation>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	/* Pagination with order*/
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping(value = "/getPagedWithOrder")
	public ResponseEntity<List<Reservation>> getPagedReservation(
			@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize, 
			@RequestParam(defaultValue = "id") String sortBy) {
		
		List<Reservation> list = service.getPagedReservationWithOrder(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<Reservation>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}
