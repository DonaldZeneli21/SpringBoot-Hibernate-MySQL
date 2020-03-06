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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Traveler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_TRAVELER")
	private Long idTraveler;
	
	@Column(name = "TRAVELER_NAME")
	private String travelerName;
	
	@Column(name = "TRAVELER_SURNAME")
	private String travelerSurname;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "TRAVELER_BIRTHDATE")
	private Date travelerBirthdate;
	
	@Column(name = "TRAVELER_EMAIL")
	private String travelerEmail;
	
	@Column(name = "PHONE_NR")
	private String phoneNr;
	
	@ManyToOne
	@JoinColumn(name = "ID_AIRPORT")
	private Airport airport;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Company> company = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "ID_DESTINATION")
	private Destination destination;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "traveler", fetch = FetchType.LAZY)
	private List<Reservation> reservation = new ArrayList<>();
	
	public Long getIdTraveler() {
		return idTraveler;
	}

	public void setIdTraveler(Long idTraveler) {
		this.idTraveler = idTraveler;
	}

	public String getTravelerName() {
		return travelerName;
	}

	public void setTravelerName(String travelerName) {
		this.travelerName = travelerName;
	}

	public String getTravelerSurname() {
		return travelerSurname;
	}

	public void setTravelerSurname(String travelerSurname) {
		this.travelerSurname = travelerSurname;
	}

	public Date getTravelerBirthdate() {
		return travelerBirthdate;
	}

	public void setTravelerBirthdate(Date travelerBirthdate) {
		this.travelerBirthdate = travelerBirthdate;
	}

	public String getTravelerEmail() {
		return travelerEmail;
	}

	public void setTravelerEmail(String travelerEmail) {
		this.travelerEmail = travelerEmail;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	public List<Company> getCompany() {
		return company;
	}

	public void setCompany(List<Company> company) {
		this.company = company;
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public List<Reservation> getReservation() {
		return reservation;
	}

	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	
}
