package com.cloudapps.relational_persistence.dbutils;

import org.springframework.stereotype.Component;

@Component
public class DatabaseQueryPrinter extends DatabasePrinter {

	public void print() {
		
		super.printTitle("REQUESTED QUERIES RESULT");
		super.printSeparator();
		
	}
	

}
