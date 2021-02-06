package com.cloudapps.relational_persistence.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="airport")
public class Airport {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "airport_id")
    private Long id;
	
	@Column(length = 3, unique = true)
    @Size(min = 3, max = 3)
	private String iataCode;
	
	private String name;
	
	private String city;
	
	private String country;
	
	@OneToMany(mappedBy = "revisionAirport")
	private List<Revision> revisions;
	
	@OneToMany(mappedBy = "departure")
	private List<Flight> departures;
	
	@OneToMany(mappedBy = "arrival")
	private List<Flight> arrivals;
	
	public Airport() {}

	public Airport(String iataCode, String name, String city, String country) {
		super();
		this.iataCode = iataCode;
		this.name = name;
		this.city = city;
		this.country = country;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIataCode() {
		return iataCode;
	}

	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Revision> getRevisions() {
		return revisions;
	}

	public void setRevisions(List<Revision> revisions) {
		this.revisions = revisions;
	}

	public List<Flight> getDepartures() {
		return departures;
	}

	public void setDepartures(List<Flight> departures) {
		this.departures = departures;
	}

	public List<Flight> getArrivals() {
		return arrivals;
	}

	public void setArrivals(List<Flight> arrivals) {
		this.arrivals = arrivals;
	}

	@Override
	public String toString() {
		return "Airport{" +
				"id=" + id + "," +
				"iataCode='" + iataCode + "'\'," +
				"name='" + name + "'\'," +
				"city='" + city + "'\'," +
				"country='" + country + "'\'" + 
				'}';
	}
	
}
