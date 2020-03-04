package com.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.model.Reservation;
import com.reservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	protected ReservationRepository repository;
	
	@Override
	public List<Reservation> getReservation() {
		
		return (List<Reservation>) repository.findAll();
	}

	@Override
	public Reservation insertReservation(Reservation request) {
		Reservation res = repository.save(request);
		res.setReservationDate(request.getReservationDate());
		res.setCanceled(request.isCanceled());
		res.setCancelDate(request.getCancelDate());
		return res;
	}

}