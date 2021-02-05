package com.cloudapps.relational_persistence.model;

import javax.persistence.Entity;

@Entity
public class CrewMember extends Employee {
	
	private String position;
	
	private String company;
	
	public CrewMember() {}

	public CrewMember(String employeeCode, String name, String surnames, String position, String company) {
		super(employeeCode, name, surnames);
		this.position = position;
		this.company = company;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Override
	public String toString() {
		return "CrewMember{" +
				"position='" + position + "'\'," +
				"company='" + company + "'\'," +
				'}';
	}	
	
}
