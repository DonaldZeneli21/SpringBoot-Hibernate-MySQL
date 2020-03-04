package com.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reservation.model.Traveler;

@Service 
public interface TravelerService {

	public List<Traveler> getTraveler();
	public Traveler insertTraveler(Traveler request);
	public List<Traveler> getPagedTravelersWithOrder(Integer pageNo, Integer pageSize, String sortBy);
	public List<Traveler> getPagedTravelers(Integer pageNo, Integer pageSize);
}
