package com.reservation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.Destination;

@Repository
public interface DestinationRepository extends CrudRepository<Destination, Long>, PagingAndSortingRepository<Destination, Long>{

}
