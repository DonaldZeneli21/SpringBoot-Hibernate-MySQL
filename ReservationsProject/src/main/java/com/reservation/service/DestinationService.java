package com.reservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reservation.model.Destination;

@Service
public interface DestinationService {

	public List<Destination> getDestination();
	public Destination insertDestination(Destination request);
	public Optional<Destination> getById(Destination request);
	public void deleteDestination(Destination request);
	
	public List<Destination> getPagedDestination(Integer pageNo, Integer pageSize);
	public List<Destination> getPagedDestinationWithOrder(Integer pageNo, Integer pageSize, String sortBy);
}
