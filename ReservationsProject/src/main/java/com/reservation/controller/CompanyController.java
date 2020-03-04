package com.reservation.controller;

import java.util.List;

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
	public ResponseEntity<List<Company>> getCompany(){
		
		List<Company> list = service.getCompany();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping(value = "/insertCompany")
	public ResponseEntity<Company> insert(@RequestBody Company request){
		
		Company inserted = service.insertCompany(request);
		return ResponseEntity.ok(inserted);
	}
}
