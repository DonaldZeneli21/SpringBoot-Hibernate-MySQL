package com.reservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.reservation.model.Company;

@Service
public interface CompanyService {

	public List<Company> getCompany();
	public Company insertCompany(Company request);
	public Optional<Company> getById(Company request);
	public void deleteCompany(Company request);
	
	public List<Company> getPagedCompany(Integer pageNo, Integer pageSize);
	public List<Company> getPagedCompanyWithOrder(Integer pageNo, Integer pageSize, String sortBy);
}
