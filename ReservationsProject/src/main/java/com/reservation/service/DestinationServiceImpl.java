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

	@Override
	public Optional<Destination> getById(Destination request) {
		
		return repository.findById(request.getIdDestination());
	}

	@Override
	public void deleteDestination(Destination request) {

		repository.deleteById(request.getIdDestination());
	}

	@Override
	public List<Destination> getPagedDestination(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
			
			Page<Destination> pagedResult = repository.findAll(paging);
			if(pagedResult.hasContent()) {
				return pagedResult.getContent();
			}else {
				return new ArrayList<Destination>();
			}

		
	}

	@Override
	public List<Destination> getPagedDestinationWithOrder(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		Page<Destination> pagedResult = repository.findAll(paging);
		if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		}else {
			return new ArrayList<Destination>();
		}
	}

}
