package com.reservation.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reservation.model.Company;
import com.reservation.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	CompanyService service;

	@GetMapping(value = "/getAll")
	public ResponseEntity<List<Company>> getAllCompany() {

		List<Company> list = service.getCompany();
		return ResponseEntity.ok(list);
	}

	@PostMapping(value = "/insertCompany")
	public ResponseEntity<Company> insertCompany(@RequestBody Company request) {

		Company company = service.insertCompany(request);
		return ResponseEntity.ok(company);
	}

	@GetMapping(value = "/getCompanyById")
	public ResponseEntity<Optional<Company>> getCompanyById(@RequestBody Company request) {

		Optional<Company> stock = service.getById(request);
		if (stock.isPresent()) {
			return ResponseEntity.ok(stock);
		} else {
			return ResponseEntity.ok(null);
		}

	}

	@PostMapping(value = "updateCompany")
	public ResponseEntity<Company> updateCompany( @RequestBody Company request) {
		Optional<Company> stock = service.getById(request); 
		if (stock.isPresent()) {
			Company company = service.insertCompany(request);
			company.setCompanyName(request.getCompanyName());
			company.setRegistrationDate(request.getRegistrationDate());
			
			return ResponseEntity.ok(company);
		}
		return ResponseEntity.ok(null);
	}
	
	@PostMapping(value = "deleteCompany")
	public ResponseEntity<?> deleteCompany(@RequestBody Company request){
		
		Optional<Company> stock = service.getById(request);
		if(stock.isPresent()) {
			service.deleteCompany(request);
			return ResponseEntity.ok("Company deleted!");
		}
		else {
			return ResponseEntity.ok("Record doesn't exist !");
		}
	}
}
