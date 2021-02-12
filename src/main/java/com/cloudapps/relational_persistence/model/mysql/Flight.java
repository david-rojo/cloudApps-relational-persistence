package com.cloudapps.relational_persistence.model.mysql;

import static com.cloudapps.relational_persistence.configuration.Constants.DATE_FORMAT;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * 
 * @author David Rojo Antona
 *
 */

@Entity
@Table(name="flight")
public class Flight {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "flight_id")
    private Long id;
	
	@Column(length = 5, unique = true)
    @Size(min = 5, max = 5)
	private String flightCode;
	
	private String company;
	
	private Date departureDateTime;
	
	private double duration;
	
	@ManyToOne
	@JoinColumn(name = "airplane_id", nullable=false)
	private Airplane airplane;
	
	@ManyToOne
    @JoinColumn(name = "departure_aiport_id", nullable=false)
	private Airport departure;
	
	@ManyToOne
    @JoinColumn(name = "arrival_aiport_id", nullable=false)
	private Airport arrival;
	
	@OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FlightCrewmember> crew = new ArrayList<>();
	
	public Flight() {}

	public Flight(String flightCode, String company, Airplane airplane, Airport departure, Airport arrival,
			Date departureDateTime, double duration) {
		super();
		this.flightCode = flightCode;
		this.company = company;
		this.airplane = airplane;
		this.departure = departure;
		this.arrival = arrival;
		this.departureDateTime = departureDateTime;
		this.duration = duration;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Airplane getAirplane() {
		return airplane;
	}

	public void setAirplane(Airplane airplane) {
		this.airplane = airplane;
	}

	public Airport getDeparture() {
		return departure;
	}

	public void setDeparture(Airport departure) {
		this.departure = departure;
	}

	public Airport getArrival() {
		return arrival;
	}

	public void setArrival(Airport arrival) {
		this.arrival = arrival;
	}

	public Date getDepartureDateTime() {
		return departureDateTime;
	}

	public void setDepartureDateTime(Date departureDateTime) {
		this.departureDateTime = departureDateTime;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public List<FlightCrewmember> getCrew() {
		return crew;
	}

	public void setCrew(List<FlightCrewmember> crew) {
		this.crew = crew;
	}

	@Override
	public String toString() {
		
		return "\tflight_id: " + id + "\n" +
			"\tflight_code: " + flightCode + "\n" + 
			"\tcompany: " + company + "\n" +
			"\tdeparture_date_time: " + new SimpleDateFormat(DATE_FORMAT).format(departureDateTime) + "\n" +
			"\tduration: " + duration + "\n" +
			"\tairplane_id: " + airplane.getId() + "\n" +
			"\tdeparture_aiport_id: " + departure.getId() + "\n" +
			"\tarrival_aiport_id: " + arrival.getId();
	}
	
}
