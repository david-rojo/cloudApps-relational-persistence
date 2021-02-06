package com.cloudapps.relational_persistence.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.cloudapps.relational_persistence.model.Airplane;
import com.cloudapps.relational_persistence.model.Airport;
import com.cloudapps.relational_persistence.model.Crewmember;
import com.cloudapps.relational_persistence.model.Employee;
import com.cloudapps.relational_persistence.model.Flight;
import com.cloudapps.relational_persistence.model.FlightCrewmember;
import com.cloudapps.relational_persistence.model.Mechanic;
import com.cloudapps.relational_persistence.model.Revision;
import com.cloudapps.relational_persistence.repository.AiportRepository;
import com.cloudapps.relational_persistence.repository.AirplaneRepository;
import com.cloudapps.relational_persistence.repository.CrewMemberRepository;
import com.cloudapps.relational_persistence.repository.EmployeeRepository;
import com.cloudapps.relational_persistence.repository.FlightRepository;
import com.cloudapps.relational_persistence.repository.MechanicRepository;
import com.cloudapps.relational_persistence.repository.RevisionRepository;

@Controller
public class DatabaseLoader implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(DatabaseLoader.class);
	
	public static String DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";

	@Autowired
	private MechanicRepository mechanicRepository;

	@Autowired
	private CrewMemberRepository crewMemberRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private AiportRepository airportRepository;

	@Autowired
	private AirplaneRepository airplaneRepository;

	@Autowired
	private RevisionRepository revisionRepository;
	
	@Autowired
	private FlightRepository flightRepository;

	@Override
	public void run(String... args) throws ParseException  {

		populateDatabase();		
		showDatabaseInfo();		
		log.info("End of execution");
	}
	
	private void showDatabaseInfo() {
		
		showCrewMembers();		
		log.info("");
		showMechanics();				
	}

	private void showCrewMembers() {
		List<Crewmember> crew = crewMemberRepository.findAll();
		log.info("Crew members:");
		log.info("-------------");
		for (int i=0; i<crew.size(); i++) {
			log.info("Crew {}:", i);
			log.info(crew.get(i).toString());
			this.printEmployee(crew.get(i), i);
			log.info("");
		}
	}

	private void showMechanics() {
		List<Mechanic> mechanics = mechanicRepository.findAll();
		log.info("Mechanics:");
		log.info("----------");
		for (int i=0; i<mechanics.size(); i++) {
			log.info("Mechanic {}:", i);
			log.info(mechanics.get(i).toString());
			this.printEmployee(mechanics.get(i), i);
			log.info("");
		}		
	}

	private void populateDatabase() throws ParseException {
		
		Crewmember lufthansaFlightAttendant = new Crewmember("1234567", "Laura", "Ruiz Herranz", "Flight Attendant", "Lufthansa");
		Crewmember lufthansaPilot = new Crewmember("2345874", "Carmen", "Torres Navarro", "Pilot", "Lufthansa");
		Crewmember lufthansaCoPilot = new Crewmember("4367231", "Daniel", "Acevedo Fuentes", "Co-pilot", "Lufthansa");

		Crewmember qatarFlightAttendant = new Crewmember("6658796", "Ana", "Calle Hidalgo", "Flight Attendant","Qatar Airways");
		Crewmember qatarPilot = new Crewmember("2214587", "Jorge", "Caballero Aparicio", "Pilot", "Qatar Airways");
		Crewmember qatarCoPilot = new Crewmember("8574233", "Miguel", "Romero Izquierdo", "Co-pilot", "Qatar Airways");

		Mechanic airbusMechanic1 = new Mechanic("7654321", "Juan", "Luque Aguilar", "Airbus", 2015, "University Degree");
		Mechanic airbusMechanic2 = new Mechanic("7651234", "Vicente", "Costero Bermejo", "Airbus", 2010, "Master Degree");
		Mechanic boeingMechanic = new Mechanic("6648392", "Fernando", "Montesinos Moreno", "Boeing", 2018, "Master Degree");
		
		Airplane lufthansaAirplane1 = new Airplane("D-AAAA", "Boeing", "747-8", 15000);
		Airplane lufthansaAirplane2 = new Airplane("D-BBBB", "Boeing", "747-400", 20000);
		Airplane qatarAirplane1 = new Airplane("A7-AAA", "Airbus", "A380", 10000);
		Airplane qatarAirplane2 = new Airplane("A7-BBB", "Airbus", "A350-1000", 8000);
		
		Airport lufthansaMainAirport = new Airport("MUC", "Franz Josef Strauss International Aiport", "Munich", "Germany");
		Airport qatarMainAirport = new Airport("DOH", "Hamad International Airport", "Doha", "Qatar");
		Airport madridAirport = new Airport("MAD", "Adolfo Suárez Madrid-Barajas Airport", "Madrid", "Spain");
		Airport maleAirport = new Airport("MLE", "Malé International Airport", "Malé", "Maldives");
		Airport bangkokAirport = new Airport("BKK", "Suvarnabhumi Airport", "Bangkok", "Thailand");
		
		Revision qatarRevision1 = new Revision(
				qatarAirplane1,
				new SimpleDateFormat(DATE_FORMAT).parse("21/12/2020 08:00:00"),
				new SimpleDateFormat(DATE_FORMAT).parse("23/12/2020 10:00:00"),
				50,
				airbusMechanic1,
				"annual",
				"annual revision description",
				qatarMainAirport);
		
		Revision qatarRevision2 = new Revision(
				qatarAirplane1,
				new SimpleDateFormat(DATE_FORMAT).parse("29/12/2020 12:00:00"),
				new SimpleDateFormat(DATE_FORMAT).parse("30/12/2020 08:00:00"),
				20,
				airbusMechanic2,
				"monthly",
				"monthly revision description",
				qatarMainAirport);
		
		Revision lufthansaRevision1 = new Revision(
				lufthansaAirplane1,
				new SimpleDateFormat(DATE_FORMAT).parse("28/12/2020 08:00:00"),
				new SimpleDateFormat(DATE_FORMAT).parse("29/12/2020 04:00:00"),
				20,
				boeingMechanic,
				"monthly",
				"monthly revision description",
				lufthansaMainAirport);
		
		Revision lufthansaRevision2 = new Revision(
				qatarAirplane2,
				new SimpleDateFormat(DATE_FORMAT).parse("27/12/2020 10:00:00"),
				new SimpleDateFormat(DATE_FORMAT).parse("28/12/2020 06:00:00"),
				20,
				airbusMechanic2,
				"monthly",
				"monthly revision description",
				qatarMainAirport);
		
		Flight lufthansaFlight1 = new Flight(
				"LH950",
				"Lufthansa",
				lufthansaAirplane1,
				madridAirport,
				lufthansaMainAirport,
				new SimpleDateFormat(DATE_FORMAT).parse("01/11/2020 12:00:00"),
				2.5);
		lufthansaFlight1.setCrew(getCrewFlight(lufthansaFlight1, lufthansaPilot, lufthansaCoPilot, lufthansaFlightAttendant));
		
		Flight lufthansaFlight2 = new Flight(
				"LH850",
				"Lufthansa",
				lufthansaAirplane2,
				lufthansaMainAirport,
				bangkokAirport,
				new SimpleDateFormat(DATE_FORMAT).parse("01/11/2020 20:00:00"),
				12);
		lufthansaFlight2.setCrew(getCrewFlight(lufthansaFlight2, lufthansaPilot, lufthansaCoPilot, lufthansaFlightAttendant));
		
		Flight qatarFlight1 = new Flight(
				"QR150",
				"Qatar Airways",
				qatarAirplane1,
				madridAirport,
				qatarMainAirport,
				new SimpleDateFormat(DATE_FORMAT).parse("05/11/2020 01:00:00"),
				7);
		qatarFlight1.setCrew(getCrewFlight(qatarFlight1, qatarPilot, qatarCoPilot, qatarFlightAttendant));
		
		Flight qatarFlight2 = new Flight(
				"QR674",
				"Qatar Airways",
				qatarAirplane2,
				qatarMainAirport,
				maleAirport,
				new SimpleDateFormat(DATE_FORMAT).parse("05/11/2020 15:00:00"),
				5);
		qatarFlight2.setCrew(getCrewFlight(qatarFlight2, qatarPilot, qatarCoPilot, qatarFlightAttendant));

		employeeRepository.saveAll(Arrays.asList(
				airbusMechanic1, airbusMechanic2, boeingMechanic));
		
		airplaneRepository.saveAll(Arrays.asList(lufthansaAirplane1, lufthansaAirplane2, qatarAirplane1,qatarAirplane2));
		
		airportRepository.saveAll(Arrays.asList(lufthansaMainAirport, qatarMainAirport,
				madridAirport, maleAirport, bangkokAirport));
				
		revisionRepository.saveAll(Arrays.asList(qatarRevision1, qatarRevision2, lufthansaRevision1, lufthansaRevision2));
		
		flightRepository.saveAll(Arrays.asList(lufthansaFlight1, lufthansaFlight2, qatarFlight1, qatarFlight2));
	}
	
	private List<FlightCrewmember> getCrewFlight(Flight flight, Crewmember pilot,
			Crewmember coPilot, Crewmember flightAttendant) {
		List<FlightCrewmember> crewFlight = new ArrayList<>();
		FlightCrewmember f1c1 = new FlightCrewmember(flight, pilot);
		FlightCrewmember f1c2 = new FlightCrewmember(flight, coPilot);
		FlightCrewmember f1c3 = new FlightCrewmember(flight, flightAttendant);
		crewFlight.addAll(Arrays.asList(f1c1,f1c2,f1c3));
		return crewFlight;
	}

	private void printEmployee(Employee e, int index) {
		log.info("employeeCode {}: {}", index, e.getEmployeeCode());
		log.info("name {}: {}", index, e.getName());
		log.info("surnames {}: {}", index, e.getSurnames());
	}	

}