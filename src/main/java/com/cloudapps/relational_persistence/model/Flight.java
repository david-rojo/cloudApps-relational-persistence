package com.cloudapps.relational_persistence.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Flight {

	@Id
	private String flightCode;
	
	private String company;
	
	private Airplane airplane;
	
	private Airport departure;
	
	private Airport arrival;
	
	private Date departureDateTime;
	
	private double duration;
	
	private List<CrewMember> crew;
	
	public Flight() {}

	public Flight(String flightCode, String company, Airplane airplane, Airport departure, Airport arrival,
			Date departureDateTime, double duration, List<CrewMember> crew) {
		super();
		this.flightCode = flightCode;
		this.company = company;
		this.airplane = airplane;
		this.departure = departure;
		this.arrival = arrival;
		this.departureDateTime = departureDateTime;
		this.duration = duration;
		this.crew = crew;
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

	public List<CrewMember> getCrew() {
		return crew;
	}

	public void setCrew(List<CrewMember> crew) {
		this.crew = crew;
	}

	@Override
	public String toString() {
		return "Flight{" +
				"flightCode='" + flightCode + "'\'," +
				"company='" + company + "'\'," +
//				"airplane='" + airplane.toString() + "'\'," +
//				"departure='" + departure.toString() + "'\'," +
//				"arrival='" + arrival.toString() + "'\'," +
				"departureDateTime='" + departureDateTime + "'\'," +
				"duration=" + duration + 
//				"crew='" + crew + "'\'," +
				'}';
	}
	
}
