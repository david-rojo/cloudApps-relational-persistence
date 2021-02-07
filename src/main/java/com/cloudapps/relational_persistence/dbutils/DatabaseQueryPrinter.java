package com.cloudapps.relational_persistence.dbutils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cloudapps.relational_persistence.dto.MechanicPerAirplaneDTO;
import com.cloudapps.relational_persistence.repository.MechanicRepository;

@Component
public class DatabaseQueryPrinter extends DatabasePrinter {

	@Autowired
	private MechanicRepository mechanicRepository;
	
	public void print() {
		
		super.printTitle("REQUESTED QUERIES RESULT");
		this.printQuery1();
		super.printSeparator();
		
	}

	private void printQuery1() {

		this.printQueryTitle(1);
		this.printQueryDescription("Per each plane, show name and surnames of the mechanics responsible of its revisions");
		List<MechanicPerAirplaneDTO> mechanicsPerAirplane = mechanicRepository.findMechanicsPerAirplane();
		this.printResultTitle(mechanicsPerAirplane.size());
		for (int i=0; i<mechanicsPerAirplane.size(); i++) {
			System.out.println("Element " + i);
			System.out.println(mechanicsPerAirplane.get(i));
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
