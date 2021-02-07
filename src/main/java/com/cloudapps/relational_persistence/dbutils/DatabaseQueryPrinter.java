package com.cloudapps.relational_persistence.dbutils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloudapps.relational_persistence.dto.FlightsByArrivalAndDateDTO;
import com.cloudapps.relational_persistence.dto.MechanicPerAirplaneDTO;
import com.cloudapps.relational_persistence.repository.FlightRepository;
import com.cloudapps.relational_persistence.repository.MechanicRepository;

@Component
public class DatabaseQueryPrinter extends DatabasePrinter {

	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private MechanicRepository mechanicRepository;
	
	public void print() {
		
		super.printTitle("REQUESTED QUERIES RESULT");
		this.printQuery1();
		this.printQuery2();
		
	}

	private void printQuery1() {

		this.printQueryTitle(1);
		this.printQueryDescription("Per each plane, show name and surnames of the mechanics responsible of its revisions.");
		List<MechanicPerAirplaneDTO> mechanicsPerAirplane = mechanicRepository.findMechanicsPerAirplane();
		this.printResultTitle(mechanicsPerAirplane.size());
		for (int i=0; i<mechanicsPerAirplane.size(); i++) {
			System.out.println("Element " + i);
			System.out.println(mechanicsPerAirplane.get(i));
			System.out.println();
		}
		super.printSeparator();		
	}
	
	private void printQuery2() {

		this.printQueryTitle(2);
		this.printQueryDescription("Given the name of a city and a date, retrieve the flights that have landed (arrival) in "
				+ "the airports of its city in this date, ordered by time.");
		
		this.printRequestParamsTitle();
		String arrivalCity = "Bangkok";
		String requestDate = "01-11-2020";
		System.out.println("Arrival city: " + arrivalCity);
		System.out.println("Request date: " + requestDate);
		
		List<FlightsByArrivalAndDateDTO> flightsByArrivalAndDate = flightRepository.findFlightsByArrivalAndDate(
				arrivalCity, 
				requestDate);
		this.printResultTitle(flightsByArrivalAndDate.size());
		for (int i=0; i<flightsByArrivalAndDate.size(); i++) {
			System.out.println("Element " + i);
			System.out.println(flightsByArrivalAndDate.get(i));
			System.out.println();
		}
		super.printSeparator();		
	}
	
	private void printQueryTitle(int order) {

		System.out.println();
		System.out.println(" ---------");
		System.out.println("| QUERY " + order + " |");
		System.out.println(" ---------");
		System.out.println();
	}
	
	private void printRequestParamsTitle() {
		
		System.out.println("REQUEST PARAMETERS:");
	}
	
	private void printQueryDescription(String description) {

		System.out.println(description);
		System.out.println();
	}
	
	private void printResultTitle(int resultLength) {

		System.out.println();
		System.out.println("RESULT: " + resultLength + " element(s)");
		System.out.println();
	}
	

}
