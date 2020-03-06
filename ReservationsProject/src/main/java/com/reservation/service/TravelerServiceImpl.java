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

import com.reservation.model.Traveler;
import com.reservation.repository.TravelerRepository;

@Service
public class TravelerServiceImpl implements TravelerService{

	@Autowired
	protected TravelerRepository repository;
	
	@Override
	public List<Traveler> getTraveler() {

		return (List<Traveler>) repository.findAll();
	}

	@Override
	public Traveler insertTraveler(Traveler request) {
		Traveler trav = repository.save(request);
		trav.setTravelerName(request.getTravelerName());
		trav.setTravelerSurname(request.getTravelerSurname());
		trav.setTravelerBirthdate(request.getTravelerBirthdate());
		return trav;
	}

	@Override
	public Optional<Traveler> getById(Traveler request) {
	
		return repository.findById(request.getIdTraveler());
	}

	@Override
	public void deleteTraveler(Traveler request) {
		
		repository.deleteById(request.getIdTraveler());
	}
	
	@Override
	public List<Traveler> getPagedTravelers(Integer pageNo, Integer pageSize) {
		 Pageable paging = PageRequest.of(pageNo, pageSize);
		 
	        Page<Traveler> pagedResult = repository.findAll(paging);
	         
	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Traveler>();
	        }
	    }
	
	@Override
	public List<Traveler> getPagedTravelersWithOrder(Integer pageNo, Integer pageSize, String sortBy) {
		
		 Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		 
	        Page<Traveler> pagedResult = repository.findAll(paging);
	         
	        if(pagedResult.hasContent()) {
	            return pagedResult.getContent();
	        } else {
	            return new ArrayList<Traveler>();
	        }
	    }

	
	}

	
