package com.reservation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Override
	public Optional<Airport> getById(Airport request) {
		
		return repository.findById(request.getIdAirport());
	}

	@Override
	public void deleteAirport(Airport request) {
		
		repository.deleteById(request.getIdAirport());
	}

	@Override
	public List<Airport> getPagedAirports(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
			Page<Airport> pagedResult = repository.findAll(paging);
			if(pagedResult.hasContent()) {
				return pagedResult.getContent();
			}else {
				return new ArrayList<Airport>();
			}
	
	}

	@Override
	public List<Airport> getPagedAirportsWithOrder(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
			Page<Airport> pagedResult = repository.findAll(paging);
			if(pagedResult.hasContent()) {
				return pagedResult.getContent();
			}else {
				return new ArrayList<Airport>();
			}
		
	}



}
