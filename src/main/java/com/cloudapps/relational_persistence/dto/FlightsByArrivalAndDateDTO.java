package com.cloudapps.relational_persistence.dto;

import static com.cloudapps.relational_persistence.configuration.Constants.DATE_FORMAT;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightsByArrivalAndDateDTO {

	private String flightCode;
	
    private String company;

    private String departureCity;
    
    private String departureIataCode;
    
    private String arrivalCity;
    
    private String arrivalIataCode;

    private Date departureDateTime;
    
    private double duration;
    
    public FlightsByArrivalAndDateDTO() {}

	public FlightsByArrivalAndDateDTO(String flightCode, String company, String departureCity, String departureIataCode,
			String arrivalCity, String arrivalIataCode, Date departureDateTime, double duration) {
		super();
		this.flightCode = flightCode;
		this.company = company;
		this.departureCity = departureCity;
		this.departureIataCode = departureIataCode;
		this.arrivalCity = arrivalCity;
		this.arrivalIataCode = arrivalIataCode;
		this.departureDateTime = departureDateTime;
		this.duration = duration;
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

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public String getArrivalIataCode() {
		return arrivalIataCode;
	}

	public void setArrivalIataCode(String arrivalIataCode) {
		this.arrivalIataCode = arrivalIataCode;
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

	@Override
	public String toString() {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT); 
		return "\tflightCode: " + flightCode + "\n" +
				"\tcompany: " + company + "\n" +
				"\tdeparture: " + departureCity  + " (" + departureIataCode + ")\n" +
				"\tarrival: " + arrivalCity + " (" + arrivalIataCode + ")\n" +
				"\tdepartureDateTime: " + simpleDateFormat.format(departureDateTime) + "\n" +
				"\tduration: " + duration;
	}
    
}
