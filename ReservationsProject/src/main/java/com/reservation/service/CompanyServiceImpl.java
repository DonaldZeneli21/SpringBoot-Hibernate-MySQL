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

	@Override
	public List<Company> getPagedCompany(Integer pageNo, Integer pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
		
			Page<Company> pagedResult = repository.findAll(paging);
			if(pagedResult.hasContent()) {
				return pagedResult.getContent();
			}else {
				return new ArrayList<Company>();
			}
		
	}

	@Override
	public List<Company> getPagedCompanyWithOrder(Integer pageNo, Integer pageSize, String sortBy) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		Page<Company> pagedResult = repository.findAll(paging);
		if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		}else {
			return new ArrayList<Company>();
		}
	
}

}
