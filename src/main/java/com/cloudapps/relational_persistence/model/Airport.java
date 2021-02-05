package com.cloudapps.relational_persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.Size;

@Entity
public class Airport {

	@Id
	@Column(length = 3)
    @Size(min = 3, max = 3)
	private String iataCode;
	
	private String name;
	
	private String city;
	
	private String country;
	
	public Airport() {}

	public Airport(String iataCode, String name, String city, String country) {
		super();
		this.iataCode = iataCode;
		this.name = name;
		this.city = city;
		this.country = country;
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

	@Override
	public String toString() {
		return "Airport{" +
				"iataCode='" + iataCode + "'\'," +
				"name='" + name + "'\'," +
				"city='" + city + "'\'," +
				"country='" + country + "'\'" + 
				'}';
	}
	
}
