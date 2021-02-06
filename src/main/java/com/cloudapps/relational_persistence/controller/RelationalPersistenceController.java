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
public class RelationalPersistenceController implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(RelationalPersistenceController.class);
	
	

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
	
	@Autowired
	private DatabaseLoader databaseLoader;

	@Override
	public void run(String... args) throws ParseException  {

		databaseLoader.load();		
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


	private void printEmployee(Employee e, int index) {
		log.info("employeeCode {}: {}", index, e.getEmployeeCode());
		log.info("name {}: {}", index, e.getName());
		log.info("surnames {}: {}", index, e.getSurnames());
	}	

}
