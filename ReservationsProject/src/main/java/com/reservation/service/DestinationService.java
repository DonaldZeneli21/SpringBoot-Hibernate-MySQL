package com.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reservation.model.Destination;

@Service
public interface DestinationService {

	public List<Destination> getDestination();
	public Destination insertDestination(Destination request);
}
