package com.cloudapps.relational_persistence.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.cloudapps.relational_persistence.repository.AiportRepository;
import com.cloudapps.relational_persistence.repository.AirplaneRepository;
import com.cloudapps.relational_persistence.repository.CrewMemberRepository;
import com.cloudapps.relational_persistence.repository.EmployeeRepository;
import com.cloudapps.relational_persistence.repository.FlightRepository;
import com.cloudapps.relational_persistence.repository.MechanicRepository;
import com.cloudapps.relational_persistence.repository.RevisionRepository;

@Controller
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private AiportRepository airportRepository;
	
	@Autowired
	private AirplaneRepository airplaneRepository;

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private MechanicRepository mechanicRepository;
	
	@Autowired
	private RevisionRepository revisionRepository;
	
	@Autowired
	private CrewMemberRepository crewMemberRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Pending to implement
		
	}

}
