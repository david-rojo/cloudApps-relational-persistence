package com.cloudapps.relational_persistence.dto;

/**
 * 
 * @author David Rojo Antona
 *
 */

public class FlightStatisticsFromCrewmemberDTO {
	
	private String name;
	
	private String surnames;
	
	private Long flights;
	
	private double flownHours;
	
	public FlightStatisticsFromCrewmemberDTO() {}

	public FlightStatisticsFromCrewmemberDTO(String name, String surnames, Long flights,
			double flownhours) {
		
		super();
		this.name = name;
		this.surnames = surnames;
		this.flights = flights;
		this.flownHours = flownhours;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public Long getFlights() {
		return flights;
	}

	public void setFlights(Long flights) {
		this.flights = flights;
	}

	public double getFlownHours() {
		return flownHours;
	}

	public void setFlownHours(double flownHours) {
		this.flownHours = flownHours;
	}
	
	@Override
	public String toString() { 

		return "\tname: " + name + "\n" +
				"\tsurnames: " + surnames + "\n" +
				"\tnumber of flights: " + flights + "\n" +
				"\tflown hours: " + flownHours;
	}	

}
