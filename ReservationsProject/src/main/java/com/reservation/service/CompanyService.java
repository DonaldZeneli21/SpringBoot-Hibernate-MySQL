package com.reservation.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.reservation.model.Company;

@Service
public interface CompanyService {

	public List<Company> getCompany();
	public Company insertCompany(Company request);
}
