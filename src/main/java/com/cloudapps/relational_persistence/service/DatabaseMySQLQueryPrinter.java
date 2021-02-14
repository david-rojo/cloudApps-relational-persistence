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
		this.printQuery1Practice1();
		this.printQuery2Practice1();
		this.printQuery3Practice1();
		this.printQuery4Practice1();		
		this.printQuery1Practice2();
	}

	private void printQuery1Practice1() {

		this.printQueryTitle(1, 1);
		this.printQueryDescription("Per each plane, show name and surnames of the mechanics responsible of its revisions.");

		List<MechanicPerAirplaneDTO> mechanicsPerAirplaneResult = mechanicRepository.findMechanicsPerAirplane();
		
		
		this.printResultTitle(mechanicsPerAirplaneResult.size());
		
		for (int i=0; i<mechanicsPerAirplaneResult.size(); i++) {
			System.out.println("Element " + i + ":");
			System.out.println(mechanicsPerAirplaneResult.get(i));
			System.out.println();
		}
		this.printSeparator();		
	}
	
	private void printQuery2Practice1() {

		this.printQueryTitle(1, 2);
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
	
	private void printQuery3Practice1() {
		
		this.printQueryTitle(1, 3);
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
	
	private void printQuery4Practice1() {

		this.printQueryTitle(1, 4);
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

	private void printQuery1Practice2() {

		this.printQueryTitle(2, 1);
		this.printQueryDescription("Practice 2 (JSON): Per each plane, show name and surnames of the mechanics responsible of its revisions.");

		List<MechanicPerAirplaneDTO> mechanicsPerAirplaneResult = mechanicRepository.findMechanicsPerAirplanePractice2();
		
		
		this.printResultTitle(mechanicsPerAirplaneResult.size());
		
		for (int i=0; i<mechanicsPerAirplaneResult.size(); i++) {
			System.out.println("Element " + i + ":");
			System.out.println(mechanicsPerAirplaneResult.get(i));
			System.out.println();
		}
		this.printSeparator();		
	}
	
	private void printQueryTitle(int practice, int order) {

		System.out.println();
		System.out.println(" ----------------------------");
		System.out.println("| PRACTICE " + practice + " - MYSQL QUERY " + order + " |");
		System.out.println(" ----------------------------");
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
