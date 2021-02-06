package com.cloudapps.relational_persistence.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mechanic")
public class Mechanic extends Employee {

	private String enterprise;
	
	private int incorporationYear;
	
	private String previousFormation;
	
	@OneToMany(mappedBy = "mechanic")
	private List<Revision> revisions;
	
	public Mechanic() {}
	
	public Mechanic(String employeeCode, String name, String surnames, String company, int incorporationYear,
			String previousFormation) {
		super(employeeCode, name, surnames);
		this.enterprise = company;
		this.incorporationYear = incorporationYear;
		this.previousFormation = previousFormation;
	}

	public String getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}

	public int getIncorporationYear() {
		return incorporationYear;
	}

	public void setIncorporationYear(int incorporationYear) {
		this.incorporationYear = incorporationYear;
	}

	public String getPreviousFormation() {
		return previousFormation;
	}

	public void setPreviousFormation(String previousFormation) {
		this.previousFormation = previousFormation;
	}

	public List<Revision> getRevisions() {
		return revisions;
	}

	public void setRevisions(List<Revision> revisions) {
		this.revisions = revisions;
	}

	@Override
	public String toString() {
		return "Mechanic{" +
				"company='" + enterprise + "'," +
				"previousFormation='" + previousFormation + "'," +
				"incorporationYear=" + incorporationYear + 
				'}';
	}
	
}
