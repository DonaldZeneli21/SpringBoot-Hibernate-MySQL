package com.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	
}
