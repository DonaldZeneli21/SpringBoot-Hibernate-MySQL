package com.reservation.model;

import java.util.ArrayList;
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
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Airport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_AIRPORT")
	private Long idAirport;
	
	@Column(name = "AIRPORT_NAME")
	private String airportName;
	
	@Column(name = "MAX_FLIGHT_IN_DAY")
	private int maxFlightInDay;
	
	@Column(name = "PEOPLE_CAPACITY")
	private int peopleCapacity;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "airport", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Traveler> traveler =  new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "airport", fetch = FetchType.LAZY)
	private List<Company> company = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "ID_DESTINATION")
	private Destination destination;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "airport", fetch = FetchType.LAZY)
	private List<Reservation> reservation = new ArrayList<>();
	
	public Long getIdAirport() {
		return idAirport;
	}

	public void setIdAirport(Long idAirport) {
		this.idAirport = idAirport;
	}

	public String getAirportName() {
		return airportName;
	}

	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}

	public int getMaxFlightInDay() {
		return maxFlightInDay;
	}

	public void setMaxFlightInDay(int maxFlightInDay) {
		this.maxFlightInDay = maxFlightInDay;
	}

	public int getPeopleCapacity() {
		return peopleCapacity;
	}

	public void setPeopleCapacity(int peopleCapacity) {
		this.peopleCapacity = peopleCapacity;
	}

	public List<Traveler> getTraveler() {
		return traveler;
	}

	public void setTraveler(List<Traveler> traveler) {
		this.traveler = traveler;
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
