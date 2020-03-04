package com.reservation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	
}
