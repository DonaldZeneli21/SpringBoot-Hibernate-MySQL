package com.reservation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.Reservation;

@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long>, PagingAndSortingRepository<Reservation, Long>{

}
