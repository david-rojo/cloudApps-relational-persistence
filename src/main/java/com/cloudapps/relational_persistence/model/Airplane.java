package com.cloudapps.relational_persistence.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Airplane {

	@Id
	private String registrationCode;
	
	private String manufacturer;
	
	private String model;
	
	private long flownHours;
	
	public Airplane() {}

	
	public Airplane(String registrationCode, String manufacturer, String model, long flownHours) {
		super();
		this.registrationCode = registrationCode;
		this.manufacturer = manufacturer;
		this.model = model;
		this.flownHours = flownHours;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public long getFlownHours() {
		return flownHours;
	}

	public void setFlownHours(long flownHours) {
		this.flownHours = flownHours;
	}

	@Override
	public String toString() {
		return "Airplane{" +
				"registrationCode='" + registrationCode + "'\'," +
				"manufacturer='" + manufacturer + "'\'," +
				"model='" + model + "'\'," +
				"flownHours=" + flownHours + 
				'}';
	}

}
