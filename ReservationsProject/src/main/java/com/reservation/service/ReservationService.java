package com.reservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reservation.model.Reservation;

@Service
public interface ReservationService {

	public List<Reservation> getReservation();
	public Reservation insertReservation(Reservation request);
	public Optional<Reservation> getById(Reservation request);
	public void deleteReservation(Reservation request);
	
	public List<Reservation> getPagedReservation(Integer pageNo, Integer pageSize);
	public List<Reservation> getPagedReservationWithOrder(Integer pageNo, Integer pageSize, String sortBy);
}
