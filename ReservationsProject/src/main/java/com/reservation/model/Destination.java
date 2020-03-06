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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Destination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_DESTINATION")
	private Long idDestination;
	
	@Column(name = "CONTINENT")
	private String continent;
	
	@Column(name = "COUNTRY")
	private String country;
	
	@Column(name = "CITY")
	private String city;
	
	@Column(name = "LOCATION")
	private String location;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "destination", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Airport> airport =  new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Company> company = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "destination", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Traveler> traveler =  new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "destination", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Reservation> reservation =  new ArrayList<>();
	
	public Long getIdDestination() {
		return idDestination;
	}
	public void setIdDestination(Long idDestination) {
		this.idDestination = idDestination;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<Airport> getAirport() {
		return airport;
	}
	public void setAirport(List<Airport> airport) {
		this.airport = airport;
	}
	public List<Company> getCompany() {
		return company;
	}
	public void setCompany(List<Company> company) {
		this.company = company;
	}
	public List<Traveler> getTraveler() {
		return traveler;
	}
	public void setTraveler(List<Traveler> traveler) {
		this.traveler = traveler;
	}
	public List<Reservation> getReservation() {
		return reservation;
	}
	public void setReservation(List<Reservation> reservation) {
		this.reservation = reservation;
	}
	
	
}
