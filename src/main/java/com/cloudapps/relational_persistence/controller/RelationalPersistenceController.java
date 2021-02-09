package com.cloudapps.relational_persistence.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.cloudapps.relational_persistence.service.DatabaseInfoPrinter;
import com.cloudapps.relational_persistence.service.DatabaseLoader;
import com.cloudapps.relational_persistence.service.DatabaseQueryPrinter;

/**
 * 
 * @author David Rojo Antona
 *
 */

@Controller
public class RelationalPersistenceController implements CommandLineRunner {

	@Autowired
	private DatabaseLoader databaseLoader;
	
	@Autowired
	private DatabaseInfoPrinter databaseInfoPrinter;
	
	@Autowired
	private DatabaseQueryPrinter databaseQueryPrinter;

	@Override
	public void run(String... args) throws ParseException  {

		databaseLoader.load();		
		databaseInfoPrinter.print();
		databaseQueryPrinter.print();
	}	

}
