package com.cloudapps.relational_persistence.dbutils;

import static com.cloudapps.relational_persistence.configuration.Constants.DATE_FORMAT;

import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

@Component
public class DatabaseInfoPrinter extends DatabasePrinter {

	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);  
	
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
		super.printTitle("INFORMATION STORED IN DB");
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
		for (int i=0; i<airports.size(); i++) {
			Airport airport = airports.get(i);
			System.out.println("\tairport_id: " + airport.getId());
			System.out.println("\tiata_code: " + airport.getIataCode());
			System.out.println("\tname: " + airport.getName());
			System.out.println("\tcity: " + airport.getCity());
			System.out.println("\tcountry: " + airport.getCountry());
			System.out.println();
		}
		super.printSeparator();
	}
	
	private void printAirplane() {

		List<Airplane> airplanes = airplaneRepository.findAll();
		System.out.println();
		System.out.println(" ---------------");
		System.out.println("| TABLE AIRPLANE |");
		System.out.println(" ---------------");
		printNumberOfRows(airplanes.size());
		for (int i=0; i<airplanes.size(); i++) {
			Airplane airplane = airplanes.get(i);
			System.out.println("Airplane " + i);
			System.out.println("\tairplane_id: " + airplane.getId());
			System.out.println("\tregistration_code: " + airplane.getRegistrationCode());
			System.out.println("\tmanufacturer: " + airplane.getManufacturer());
			System.out.println("\tmodel: " + airplane.getModel());
			System.out.println("\tflown_hours: " + airplane.getFlownHours());
			System.out.println();
		}
		super.printSeparator();
	}
	
	private void printCrewmember() {

		List<Crewmember> crew = crewmemberRepository.findAll();
		System.out.println();
		System.out.println(" ------------------");
		System.out.println("| TABLE CREWMEMBER |");
		System.out.println(" ------------------");
		printNumberOfRows(crew.size());
		for (int i=0; i<crew.size(); i++) {
			Crewmember crewmember = crew.get(i);
			System.out.println("\temployee_id: " + crewmember.getId());
			System.out.println("\temployee_code: " + crewmember.getEmployeeCode());
			System.out.println("\tname: " + crewmember.getName());
			System.out.println("\tsurnames: " + crewmember.getSurnames());
			System.out.println("\tcompany: " + crewmember.getCompany());
			System.out.println("\tposition: " + crewmember.getPosition());
			System.out.println();
		}
		super.printSeparator();
	}
	
	private void printMechanic() {

		List<Mechanic> mechanics = mechanicRepository.findAll();
		System.out.println();
		System.out.println(" ----------------");
		System.out.println("| TABLE MECHANIC |");
		System.out.println(" ----------------");
		printNumberOfRows(mechanics.size());
		for (int i=0; i<mechanics.size(); i++) {
			Mechanic mechanic = mechanics.get(i);
			System.out.println("\temployee_id: " + mechanic.getId());
			System.out.println("\temployee_code: " + mechanic.getEmployeeCode());
			System.out.println("\tname: " + mechanic.getName());
			System.out.println("\tsurnames: " + mechanic.getSurnames());
			System.out.println("\tenterprise: " + mechanic.getEnterprise());
			System.out.println("\tincorporation_year: " + mechanic.getIncorporationYear());
			System.out.println("\tprevious_formation: " + mechanic.getPreviousFormation());
			System.out.println();
		}
		super.printSeparator();
	}
	
	private void printRevision() {

		List<Revision> revisions = revisionRepository.findAll();
		System.out.println();
		System.out.println(" ----------------");
		System.out.println("| TABLE REVISION |");
		System.out.println(" ----------------");
		printNumberOfRows(revisions.size());
		for (int i=0; i<revisions.size(); i++) {
			Revision revision = revisions.get(i);
			System.out.println("\tid: " + revision.getId());
			System.out.println("\trevision_type: " + revision.getRevisionType());
			System.out.println("\tdescription: " + revision.getDescription());
			System.out.println("\tstart_date: " + simpleDateFormat.format(revision.getStartDate()));
			System.out.println("\tend_date: " + simpleDateFormat.format(revision.getEndDate()));
			System.out.println("\tspent_hours: " + revision.getSpentHours());
			System.out.println("\temployee_id: " + revision.getMechanic().getId());
			System.out.println("\tairplane_id: " + revision.getRevisedAirplane().getId());
			System.out.println("\tairport_id: " + revision.getRevisionAirport().getId());
			System.out.println();
		}
		super.printSeparator();
	}
	
	private void printFlight() {

		List<Flight> flights = flightRepository.findAll();
		System.out.println();
		System.out.println(" --------------");
		System.out.println("| TABLE FLIGHT |");
		System.out.println(" --------------");
		printNumberOfRows(flights.size());
		for (int i=0; i<flights.size(); i++) {
			Flight flight = flights.get(i);
			System.out.println("\tflight_id: " + flight.getId());
			System.out.println("\tflight_code: " + flight.getFlightCode());
			System.out.println("\tcompany: " + flight.getCompany());
			System.out.println("\tdeparture_date_time: " + simpleDateFormat.format(flight.getDepartureDateTime()));
			System.out.println("\tduration: " + flight.getDuration());
			System.out.println("\tairplane_id: " + flight.getAirplane().getId());
			System.out.println("\tdeparture_aiport_id: " + flight.getDeparture().getId());
			System.out.println("\tarrival_aiport_id: " + flight.getArrival().getId());
			System.out.println();
		}
		super.printSeparator();
	}
	
	private void printFlightCrewmember() {

		List<FlightCrewmember> flightCrewmemberRelations = flightCrewmemberRepository.findAll();
		System.out.println();
		System.out.println(" -------------------------");
		System.out.println("| TABLE FLIGHT_CREWMEMBER |");
		System.out.println(" -------------------------");
		printNumberOfRows(flightCrewmemberRelations.size());
		for (int i=0; i<flightCrewmemberRelations.size(); i++) {
			FlightCrewmember flightCrewmemberRelation = flightCrewmemberRelations.get(i);
			System.out.println("\tflight_flight_id: " + flightCrewmemberRelation.getFlight().getId());
			System.out.println("\tcrewmember_employee_id: " + flightCrewmemberRelation.getCrewmember().getId());
			System.out.println();
		}
		super.printSeparator();
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
