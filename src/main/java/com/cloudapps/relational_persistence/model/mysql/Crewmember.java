package com.cloudapps.relational_persistence.model.mysql;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author David Rojo Antona
 *
 */

@Entity
@Table(name="crewmember")
public class Crewmember extends Employee {
	
	private String position;
	
	private String company;
	
	@OneToMany(mappedBy = "crewmember", cascade = CascadeType.ALL)
    private List<FlightCrewmember> flights;
	
	public Crewmember() {}

	public Crewmember(String employeeCode, String name, String surnames, String position, String company) {
		super(employeeCode, name, surnames);
		this.position = position;
		this.company = company;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<FlightCrewmember> getFlights() {
		return flights;
	}

	public void setFlights(List<FlightCrewmember> flights) {
		this.flights = flights;
	}

	@Override
	public String toString() {
		
		return "\temployee_id: " + this.getId() + "\n" +
				"\temployee_code: " + this.getName() + "\n" +
				"\tname: " + this.getName() + "\n" +
				"\tsurnames: " + this.getSurnames() + "\n" +
				"\tcompany: " + company + "\n" +
				"\tposition: " + position;
	}	
	
}
