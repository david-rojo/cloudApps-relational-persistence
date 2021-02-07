package com.cloudapps.relational_persistence.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.cloudapps.relational_persistence.dbutils.DatabaseLoader;
import com.cloudapps.relational_persistence.dbutils.DatabasePrinter;

@Controller
public class RelationalPersistenceController implements CommandLineRunner {

	private Logger log = LoggerFactory.getLogger(RelationalPersistenceController.class);
	
	@Autowired
	private DatabaseLoader databaseLoader;
	
	@Autowired
	private DatabasePrinter databasePrinter;

	@Override
	public void run(String... args) throws ParseException  {

		databaseLoader.load();		
		databasePrinter.print();
		log.info("End of execution");
	}	

}
