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
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_RESERVATION")
	private Long idReservation;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "RESERVATION_DATE")
	private Date reservationDate;
	
	@Column(name = "IS_CANCELED")
	private boolean isCanceled;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "CANCEL_DATE")
	private Date cancelDate;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Airport> airport = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Company> company = new ArrayList<>();
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Traveler> traveler = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "ID_DESTINATION")
	private Destination destination;
	
	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}

	public boolean isCanceled() {
		return isCanceled;
	}

	public void setCanceled(boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	public Date getCancelDate() {
		return cancelDate;
	}

	public void setCancelDate(Date cancelDate) {
		this.cancelDate = cancelDate;
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

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	
}
