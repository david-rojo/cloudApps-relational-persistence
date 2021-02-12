package com.cloudapps.relational_persistence.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import com.cloudapps.relational_persistence.service.DatabaseMongoQueryPrinter;
import com.cloudapps.relational_persistence.service.DatabaseMySQLInfoPrinter;
//import com.cloudapps.relational_persistence.service.DatabaseLoader;
import com.cloudapps.relational_persistence.service.DatabaseMySQLQueryPrinter;

/**
 * 
 * @author David Rojo Antona
 *
 */

@Controller
public class RelationalPersistenceController implements CommandLineRunner {

//	@Autowired
//	private DatabaseMYSQLLoader databaseMySQLLoader;
	
	@Autowired
	private DatabaseMySQLInfoPrinter databaseMySQLInfoPrinter;
	
	@Autowired
	private DatabaseMySQLQueryPrinter databaseMySQLQueryPrinter;
	
	@Autowired
	private DatabaseMongoQueryPrinter databaseMongoQueryPrinter;
	
	@Override
	public void run(String... args) throws ParseException  {

		//Data loading disabled, this process is doing now using FlyWay
		//databaseLoader.load();		
		
		//Print info
		databaseMySQLInfoPrinter.print();
		
		//Print queries
		databaseMySQLQueryPrinter.print();
		databaseMongoQueryPrinter.print();
	}	

}
