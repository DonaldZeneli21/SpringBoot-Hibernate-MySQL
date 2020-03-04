package com.reservation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.Airport;

@Repository
public interface AirportRepository extends CrudRepository<Airport, Long>{

}
