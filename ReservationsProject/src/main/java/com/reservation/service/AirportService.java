package com.reservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reservation.model.Airport;

@Service
public interface AirportService {

	public List<Airport> getAirport();
	public Airport insertAirport(Airport request);
	public Optional<Airport> getById(Airport request);
	public void deleteAirport(Airport request);
	
	public List<Airport> getPagedAirports(Integer pageNo, Integer pageSize);
	public List<Airport> getPagedAirportsWithOrder(Integer pageNo, Integer pageSize, String sortBy);
}
