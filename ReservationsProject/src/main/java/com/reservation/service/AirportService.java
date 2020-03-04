package com.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reservation.model.Airport;

@Service
public interface AirportService {

	public List<Airport> getAirport();
	public Airport insertAirport(Airport request);
}
