package com.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reservation.model.Reservation;

@Service
public interface ReservationService {

	public List<Reservation> getReservation();
	public Reservation insertReservation(Reservation request);
}
