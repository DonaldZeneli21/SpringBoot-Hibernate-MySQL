package com.reservation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Represents a company 
 */

@Entity
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_COMPANY")
	private Long idCompany;
	
	@Column(name = "COMPANY_NAME")
	private String companyName;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "REGISTRATION_DATE")
	private Date registrationDate;
	
	public Long getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	
}
