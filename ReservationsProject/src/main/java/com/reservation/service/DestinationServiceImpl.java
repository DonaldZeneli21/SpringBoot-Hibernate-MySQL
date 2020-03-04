package com.reservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.model.Destination;
import com.reservation.repository.DestinationRepository;

@Service
public class DestinationServiceImpl implements DestinationService{

	@Autowired
	protected DestinationRepository repository;
	
	@Override
	public List<Destination> getDestination() {
		
		return (List<Destination>) repository.findAll();
	}

	@Override
	public Destination insertDestination(Destination request) {
		Destination dest = repository.save(request);
		dest.setContinent(request.getContinent());
		dest.setCountry(request.getCountry());
		dest.setCity(request.getCity());
		dest.setLocation(request.getLocation());
		return dest;
	}

}
