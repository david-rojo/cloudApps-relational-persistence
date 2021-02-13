package com.cloudapps.relational_persistence.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudapps.relational_persistence.dto.mysql.DepartureCitiesAndDateFromEmployeeDTO;
import com.cloudapps.relational_persistence.dto.mysql.FlightStatisticsFromCrewmemberDTO;
import com.cloudapps.relational_persistence.dto.mysql.FlightsByArrivalAndDateDTO;
import com.cloudapps.relational_persistence.dto.mysql.MechanicPerAirplaneDTO;
import com.cloudapps.relational_persistence.repository.mysql.CrewmemberRepository;
import com.cloudapps.relational_persistence.repository.mysql.FlightRepository;
import com.cloudapps.relational_persistence.repository.mysql.MechanicRepository;

/**
 * 
 * @author David Rojo Antona
 *
 */

@Service
public class DatabaseMySQLQueryPrinter extends DatabasePrinter {

	@Autowired
	private CrewmemberRepository crewmemberRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private MechanicRepository mechanicRepository;
	
	public void print() {
		
		this.printTitle("REQUESTED MYSQL QUERIES RESULT");
		this.printQuery1();
		this.printQuery2();
		this.printQuery3();
		this.printQuery4();		
	}

	private void printQuery1() {

		this.printQueryTitle(1);
		this.printQueryDescription("Per each plane, show name and surnames of the mechanics responsible of its revisions.");

		List<MechanicPerAirplaneDTO> mechanicsPerAirplaneResult = mechanicRepository.findMechanicsPerAirplane();
		
		//Delete repeated elements, because I don't have found the way to do it with only query
		HashMap<String,MechanicPerAirplaneDTO> deleteRepeatedElements = new HashMap<>();
		mechanicsPerAirplaneResult.forEach(element -> deleteRepeatedElements.put(element.getRegistrationCode(), element));
		
		this.printResultTitle(deleteRepeatedElements.size());
		
		int i = 0;		
		for (Map.Entry < String, MechanicPerAirplaneDTO > entry: deleteRepeatedElements.entrySet()) {
			System.out.println("Element " + i + ":");
			System.out.println(entry.getValue());
			System.out.println();
		}
		this.printSeparator();		
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
		
		List<FlightsByArrivalAndDateDTO> flightsByArrivalAndDateResult = flightRepository.findFlightsByArrivalAndDate(
				arrivalCity, 
				requestDate);
		this.printResultTitle(flightsByArrivalAndDateResult.size());
		for (int i=0; i<flightsByArrivalAndDateResult.size(); i++) {
			System.out.println("Element " + i + ":");
			System.out.println(flightsByArrivalAndDateResult.get(i));
			System.out.println();
		}
		this.printSeparator();		
	}
	
	private void printQuery3() {
		
		this.printQueryTitle(3);
		this.printQueryDescription("Given the employee code of a crew member, show his name, surnames and the cities"
				+ " where he has taken off with the take off date.");
		
		this.printRequestParamsTitle();
		String employeeCode = "2214587";
		System.out.println("Employee code: " + employeeCode);
		
		List<DepartureCitiesAndDateFromEmployeeDTO> departureCitiesAndDateFromEmployeeResult = crewmemberRepository
				.findDepartureCitiesAndDateByEmployeeCode(employeeCode);
		this.printResultTitle(departureCitiesAndDateFromEmployeeResult.size());
		for (int i=0; i<departureCitiesAndDateFromEmployeeResult.size(); i++) {
			System.out.println("Element " + i + ":");
			System.out.println(departureCitiesAndDateFromEmployeeResult.get(i));
			System.out.println();
		}
		this.printSeparator();
		
	}
	
	private void printQuery4() {

		this.printQueryTitle(4);
		this.printQueryDescription("For each crew member, show his name and surnames with its total number of flights "
				+ "and the sum of hours of these flights.");
		
		List<FlightStatisticsFromCrewmemberDTO> flightStatisticsFromCrewmemberResult = crewmemberRepository
				.findFlightStatistics();
		this.printResultTitle(flightStatisticsFromCrewmemberResult.size());
		for (int i=0; i<flightStatisticsFromCrewmemberResult.size(); i++) {
			System.out.println("Element " + i + ":");
			System.out.println(flightStatisticsFromCrewmemberResult.get(i));
			System.out.println();
		}

	}
	
	private void printQueryTitle(int order) {

		System.out.println();
		System.out.println(" ---------------");
		System.out.println("| MYSQL QUERY " + order + " |");
		System.out.println(" ---------------");
		System.out.println();
	}
	
	private void printRequestParamsTitle() {
		
		System.out.println("REQUEST PARAMETER(S):");
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
