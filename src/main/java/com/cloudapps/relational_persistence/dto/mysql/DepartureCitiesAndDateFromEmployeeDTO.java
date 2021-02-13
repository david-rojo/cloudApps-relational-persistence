package com.cloudapps.relational_persistence.dto.mysql;

import static com.cloudapps.relational_persistence.configuration.Constants.DATE_FORMAT;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * @author David Rojo Antona
 *
 */

public class DepartureCitiesAndDateFromEmployeeDTO {
	
	private String name;
	
	private String surnames;
	
	private String departureCity;
	
	private String departureIataCode;
	
	private Date departureDate;
	
	public DepartureCitiesAndDateFromEmployeeDTO() {}

	public DepartureCitiesAndDateFromEmployeeDTO(String name, String surnames, String departureCity,
			String departureIataCode, Date departureDate) {
		super();
		this.name = name;
		this.surnames = surnames;
		this.departureCity = departureCity;
		this.departureIataCode = departureIataCode;
		this.departureDate = departureDate;
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

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDepartureIataCode() {
		return departureIataCode;
	}

	public void setDepartureIataCode(String departureIataCode) {
		this.departureIataCode = departureIataCode;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	
	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT); 
		return "\tname: " + name + "\n" +
				"\tsurnames: " + surnames + "\n" +
				"\tdeparture: " + departureCity  + " (" + departureIataCode + ")\n" +
				"\tdepartureDateTime: " + simpleDateFormat.format(departureDate);
	}

}
