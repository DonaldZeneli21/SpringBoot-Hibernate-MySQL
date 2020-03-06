package com.reservation.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.model.Company;
import com.reservation.repository.CompanyRepository;

@Service
public class CompanyServiceImpl implements CompanyService{

	@Autowired
	protected CompanyRepository repository;
	
	@Override
	public List<Company> getCompany() {
		
		return (List<Company>) repository.findAll();
	}

	@Override
	public Company insertCompany(Company request) {
		Company company = repository.save(request);
		company.setCompanyName(request.getCompanyName());
		company.setRegistrationDate(request.getRegistrationDate());
		return company;
	}

	@Override
	public Optional<Company> getById(Company request) {
		
		return repository.findById(request.getIdCompany());
	}

	@Override
	public void deleteCompany(Company request) {
		
		repository.deleteById(request.getIdCompany());
	}

}
