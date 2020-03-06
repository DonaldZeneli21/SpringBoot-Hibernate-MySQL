package com.reservation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Airport> airport = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "company",  fetch = FetchType.LAZY)
	private List<Traveler> traveler = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "company",  fetch = FetchType.LAZY)
	private List<Destination> destination = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "company",  fetch = FetchType.LAZY)
	private List<Reservation> reservation = new ArrayList<>();
	
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
	public List<Airport> getAirport() {
		return airport;
	}
	public void setAirport(List<Airport> airport) {
		this.airport = airport;
	}
	public List<Traveler> getTraveler() {
		return traveler;
	}
	public void setTraveler(List<Traveler> traveler) {
		this.traveler = traveler;
	}
	public List<Destination> getDestination() {
		return destination;
	}
	public void setDestination(List<Destination> destination) {
		this.destination = destination;
	}
	public List<Reservation> getReservation() {
		return reservation;
	}
	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	
}
