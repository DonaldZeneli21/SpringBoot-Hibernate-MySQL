package com.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.model.Airport;
import com.reservation.repository.AirportRepository;

@Service
public class AirportServiceImpl implements AirportService{

	@Autowired
	protected AirportRepository repository;
	
	@Override
	public List<Airport> getAirport() {
		
		return (List<Airport>) repository.findAll();
	}

	@Override
	public Airport insertAirport(Airport request) {
		Airport airport = repository.save(request);
		airport.setAirportName(request.getAirportName());
		airport.setMaxFlightInDay(request.getMaxFlightInDay());
		airport.setPeopleCapacity(request.getPeopleCapacity());
		return airport;
	}

}
