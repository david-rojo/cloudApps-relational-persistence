package com.cloudapps.relational_persistence.dbutils;

public abstract class DatabasePrinter {

	protected void printTitle(String title) {

		System.out.println();
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println("**                          **");
		System.out.println("** " + title + " **");
		System.out.println("**                          **");
		System.out.println("******************************");
		System.out.println("******************************");
		System.out.println();
	}
	
	protected void printSeparator() {

		System.out.println("******************************");
	}
}
