package com.cloudapps.relational_persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudapps.relational_persistence.model.Airplane;
import com.cloudapps.relational_persistence.model.Airport;
import com.cloudapps.relational_persistence.model.Crewmember;
import com.cloudapps.relational_persistence.model.Flight;
import com.cloudapps.relational_persistence.model.FlightCrewmember;
import com.cloudapps.relational_persistence.model.Mechanic;
import com.cloudapps.relational_persistence.model.Revision;
import com.cloudapps.relational_persistence.repository.AiportRepository;
import com.cloudapps.relational_persistence.repository.AirplaneRepository;
import com.cloudapps.relational_persistence.repository.CrewmemberRepository;
import com.cloudapps.relational_persistence.repository.FlightCrewmemberRepository;
import com.cloudapps.relational_persistence.repository.FlightRepository;
import com.cloudapps.relational_persistence.repository.MechanicRepository;
import com.cloudapps.relational_persistence.repository.RevisionRepository;

/**
 * 
 * @author David Rojo Antona
 *
 */

@Service
public class DatabaseInfoPrinter extends DatabasePrinter {  
	
	@Autowired
	private AiportRepository airportRepository;
	
	@Autowired
	private AirplaneRepository airplaneRepository;
	
	@Autowired
	private CrewmemberRepository crewmemberRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private FlightCrewmemberRepository flightCrewmemberRepository;
	
	@Autowired
	private MechanicRepository mechanicRepository;
	
	@Autowired
	private RevisionRepository revisionRepository;
	
	public void print() {

		this.printLogo();
		this.printTitle("INFORMATION STORED IN DB");
		this.printAirport();
		this.printAirplane();
		this.printMechanic();
		this.printCrewmember();
		this.printRevision();
		this.printFlight();
		this.printFlightCrewmember();
	}	
	
	private void printAirport() {

		List<Airport> airports = airportRepository.findAll();
		System.out.println();
		System.out.println(" ---------------");
		System.out.println("| TABLE AIRPORT |");
		System.out.println(" ---------------");
		printNumberOfRows(airports.size());
		for (Airport airport : airports) {
			System.out.println(airport);
			System.out.println();
		}
		this.printSeparator();
	}
	
	private void printAirplane() {

		List<Airplane> airplanes = airplaneRepository.findAll();
		System.out.println();
		System.out.println(" ---------------");
		System.out.println("| TABLE AIRPLANE |");
		System.out.println(" ---------------");
		printNumberOfRows(airplanes.size());
		for (Airplane airplane : airplanes) {
			System.out.println(airplane);
			System.out.println();
		}
		this.printSeparator();
	}
	
	private void printCrewmember() {

		List<Crewmember> crew = crewmemberRepository.findAll();
		System.out.println();
		System.out.println(" ------------------");
		System.out.println("| TABLE CREWMEMBER |");
		System.out.println(" ------------------");
		printNumberOfRows(crew.size());
		for (Crewmember crewmember : crew) {
			System.out.println(crewmember);
			System.out.println();
		}
		this.printSeparator();
	}
	
	private void printMechanic() {

		List<Mechanic> mechanics = mechanicRepository.findAll();
		System.out.println();
		System.out.println(" ----------------");
		System.out.println("| TABLE MECHANIC |");
		System.out.println(" ----------------");
		printNumberOfRows(mechanics.size());
		for (Mechanic mechanic : mechanics) {
			System.out.println(mechanic);
			System.out.println();
		}
		this.printSeparator();
	}
	
	private void printRevision() {

		List<Revision> revisions = revisionRepository.findAll();
		System.out.println();
		System.out.println(" ----------------");
		System.out.println("| TABLE REVISION |");
		System.out.println(" ----------------");
		printNumberOfRows(revisions.size());
		for (Revision revision : revisions) {
			System.out.println(revision);
			System.out.println();
		}
		this.printSeparator();
	}
	
	private void printFlight() {

		List<Flight> flights = flightRepository.findAll();
		System.out.println();
		System.out.println(" --------------");
		System.out.println("| TABLE FLIGHT |");
		System.out.println(" --------------");
		printNumberOfRows(flights.size());
		for (Flight flight : flights) {
			System.out.println(flight);
			System.out.println();
		}
		this.printSeparator();
	}
	
	private void printFlightCrewmember() {

		List<FlightCrewmember> flightCrewmemberRelations = flightCrewmemberRepository.findAll();
		System.out.println();
		System.out.println(" -------------------------");
		System.out.println("| TABLE FLIGHT_CREWMEMBER |");
		System.out.println(" -------------------------");
		printNumberOfRows(flightCrewmemberRelations.size());
		for (FlightCrewmember flightCrewmemberRelation : flightCrewmemberRelations) {
			System.out.println("\tflight_flight_id: " + flightCrewmemberRelation.getFlight().getId());
			System.out.println("\tcrewmember_employee_id: " + flightCrewmemberRelation.getCrewmember().getId());
			System.out.println();
		}
	}
	
	private void printNumberOfRows(int rows) {

		System.out.println();
		System.out.println("Number of rows: " + rows);
		System.out.println();
	}

	private void printLogo() {

		System.out.println("");
		System.out.println("                                    |");
		System.out.println("                                    |");
		System.out.println("                                    |");
		System.out.println("                                  .-'-.");
		System.out.println("                                 ' ___ '");
		System.out.println("                       ---------'  .-.  '---------");
		System.out.println("       _________________________'  '-'  '_________________________");
		System.out.println("        ''''''-|---|--/    \\==][^',_m_,'^][==/    \\--|---|-''''''");
		System.out.println("                      \\    /  ||/   H   \\||  \\    /");
		System.out.println("                       '--'   OO   O|O   OO   '--'");
		System.out.println("");
	}
	
}
