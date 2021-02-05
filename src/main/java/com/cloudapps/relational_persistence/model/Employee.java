package com.cloudapps.relational_persistence.model;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Employee {

	@Id
	private String employeeCode;

	private String name;
	
	private String surnames;
	
	public Employee() {}

	public Employee(String employeeCode, String name, String surnames) {
		super();
		this.employeeCode = employeeCode;
		this.name = name;
		this.surnames = surnames;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"employeeCode='" + employeeCode + "'\'," +
				"name='" + name + "'\'," +
				"surnames='" + surnames + "'\'," +
				'}';
	}
}
