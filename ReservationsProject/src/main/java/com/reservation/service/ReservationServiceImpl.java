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

import com.reservation.model.Reservation;
import com.reservation.repository.ReservationRepository;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	protected ReservationRepository repository;
	
	@Override
	public List<Reservation> getReservation() {
		
		return (List<Reservation>) repository.findAll();
	}

	@Override
	public Reservation insertReservation(Reservation request) {
		Reservation res = repository.save(request);
		res.setReservationDate(request.getReservationDate());
		res.setCanceled(request.isCanceled());
		res.setCancelDate(request.getCancelDate());
		return res;
	}

	@Override
	public Optional<Reservation> getById(Reservation request) {
		
		return repository.findById(request.getIdReservation());
	}

	@Override
	public void deleteReservation(Reservation request) {
		
		repository.deleteById(request.getIdReservation());
	}

	@Override
	public List<Reservation> getPagedReservation(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
			Page<Reservation> pagedResult = repository.findAll(paging);
			if(pagedResult.hasContent()) {
				return pagedResult.getContent();
			}else {
				return new ArrayList<Reservation>();
			}
		
	}

	@Override
	public List<Reservation> getPagedReservationWithOrder(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		Page<Reservation> pagedResult = repository.findAll(paging);
		if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		}else {
			return new ArrayList<Reservation>();
		}
	
}



}
