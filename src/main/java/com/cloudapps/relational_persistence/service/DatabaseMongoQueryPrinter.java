package com.cloudapps.relational_persistence.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudapps.relational_persistence.model.mongo.Provincia;
import com.cloudapps.relational_persistence.repository.mongo.ProvinciasRepository;

@Service
public class DatabaseMongoQueryPrinter extends DatabasePrinter {

	@Autowired
	private ProvinciasRepository provinciasRepository;
	
	public void print() {
		
		this.printTitle("REQUESTED MONGO QUERIES RESULT");
		this.printProvincias();
	}

	private void printProvincias() {
		
		this.printQueryTitle(1);
		this.printQueryDescription("Listado de los datos de todas las provincias.");

		List<Provincia> provincias = provinciasRepository.findAll();
		this.printResultTitle(provincias.size());
		for (Provincia provincia : provincias) {
			System.out.println(provincia);
			System.out.println();
		}
		this.printSeparator();
	}
	
	private void printResultTitle(int resultLength) {

		System.out.println();
		System.out.println("RESULT: " + resultLength + " element(s)");
		System.out.println();
	}
	
	private void printQueryTitle(int order) {

		System.out.println();
		System.out.println(" ---------------");
		System.out.println("| MONGO QUERY " + order + " |");
		System.out.println(" ---------------");
		System.out.println();
	}
	
	private void printQueryDescription(String description) {

		System.out.println(description);
		System.out.println();
	}
	
}
