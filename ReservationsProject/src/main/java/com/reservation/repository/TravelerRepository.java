package com.reservation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.Traveler;

@Repository
public interface TravelerRepository extends CrudRepository<Traveler, Long>, PagingAndSortingRepository<Traveler, Long> {

}
