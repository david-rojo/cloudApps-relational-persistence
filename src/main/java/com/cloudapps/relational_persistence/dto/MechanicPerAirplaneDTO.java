package com.cloudapps.relational_persistence.dto;

public class MechanicPerAirplaneDTO {
	
	private String registrationCode;
	
	private String name;
	
	private String surnames;
	
	public MechanicPerAirplaneDTO() {}

	public MechanicPerAirplaneDTO(String registrationCode, String name, String surnames) {
		
		super();
		this.registrationCode = registrationCode;
		this.name = name;
		this.surnames = surnames;
	}

	public String getRegistrationCode() {
		return registrationCode;
	}

	public void setRegistrationCode(String registrationCode) {
		this.registrationCode = registrationCode;
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

		return "\tregistrationCode: " + registrationCode + "\n" +
				"\tname: " + name + "\n" +
				"\tsurnames: " + surnames;
	}

}
