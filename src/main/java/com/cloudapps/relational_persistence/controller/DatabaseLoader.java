package com.cloudapps.relational_persistence.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.cloudapps.relational_persistence.model.Airplane;
import com.cloudapps.relational_persistence.model.Airport;
import com.cloudapps.relational_persistence.model.CrewMember;
import com.cloudapps.relational_persistence.model.Employee;
import com.cloudapps.relational_persistence.model.Mechanic;
import com.cloudapps.relational_persistence.repository.AiportRepository;
import com.cloudapps.relational_persistence.repository.AirplaneRepository;
import com.cloudapps.relational_persistence.repository.CrewMemberRepository;
import com.cloudapps.relational_persistence.repository.EmployeeRepository;
import com.cloudapps.relational_persistence.repository.MechanicRepository;

@Controller
public class DatabaseLoader implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

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

	//	@Autowired
	//	private RevisionRepository revisionRepository;
	
	//	@Autowired
	//	private FlightRepository flightRepository;


	@Override
	public void run(String... args) throws Exception {

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
		List<CrewMember> crew = crewMemberRepository.findAll();
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

	private void populateDatabase() {
		
		CrewMember lufthansaFlightAttendant = new CrewMember("1234567", "Laura", "Ruiz Herranz", "Flight Attendant", "Lufthansa");
		CrewMember lufthansaPilot = new CrewMember("2345874", "Carmen", "Torres Navarro", "Pilot", "Lufthansa");
		CrewMember lufthansaCoPilot = new CrewMember("4367231", "Daniel", "Acevedo Fuentes", "Co-pilot", "Lufthansa");

		CrewMember qatarFlightAttendant = new CrewMember("6658796", "Ana", "Calle Hidalgo", "Flight Attendant", "Qatar Airways");
		CrewMember qatarPilot = new CrewMember("2214587", "Jorge", "Caballero Aparicio", "Pilot", "Qatar Airways");
		CrewMember qatarCoPilot = new CrewMember("8574233", "Miguel", "Romero Izquierdo", "Co-pilot", "Qatar Airways");

		Mechanic airbusMechanic = new Mechanic("7654321", "Juan", "Luque Aguilar", "Airbus", 2015, "University Degree");
		Mechanic boeingMechanic = new Mechanic("6648392", "Fernando", "Montesinos Moreno", "Boeing", 2018, "Master Degree");
		
		Airplane lufthansaAirplane1 = new Airplane("D-AAAA", "Boeing", "747-8", 15000);
		Airplane lufthansaAirplane2 = new Airplane("D-BBBB", "Boeing", "747-400", 15000);
		Airplane qatarAirplane1 = new Airplane("A7-AAA", "Airbus", "A380", 10000);
		Airplane qatarAirplane2 = new Airplane("A7-BBB", "Airbus", "A350-1000", 8000);
		
		Airport lufthansaAirport = new Airport("MUC", "Franz Josef Strauss International Aiport", "Munich", "Germany");
		Airport qatarAirport = new Airport("DOH", "Hamad International Airport", "Doha", "Qatar");

		employeeRepository.save(lufthansaFlightAttendant);
		employeeRepository.save(lufthansaPilot);
		employeeRepository.save(lufthansaCoPilot);

		employeeRepository.save(qatarFlightAttendant);
		employeeRepository.save(qatarPilot);
		employeeRepository.save(qatarCoPilot);

		employeeRepository.save(airbusMechanic);
		employeeRepository.save(boeingMechanic);
		
		airplaneRepository.save(lufthansaAirplane1);
		airplaneRepository.save(lufthansaAirplane2);
		airplaneRepository.save(qatarAirplane1);
		airplaneRepository.save(qatarAirplane2);
		
		airportRepository.save(lufthansaAirport);
		airportRepository.save(qatarAirport);		
	}
	
	private void printEmployee(Employee e, int index) {
		log.info("employeeCode {}: {}", index, e.getEmployeeCode());
		log.info("name {}: {}", index, e.getName());
		log.info("surnames {}: {}", index, e.getSurnames());
	}

		

}
