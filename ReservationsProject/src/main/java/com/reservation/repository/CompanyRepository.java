package com.reservation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.reservation.model.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long>, PagingAndSortingRepository<Company, Long>{



}
