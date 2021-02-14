package com.cloudapps.relational_persistence.model.mysql;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author David Rojo Antona
 *
 */

@Entity
@Table(name="airplane")
public class Airplane {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "airplane_id")
    private Long id;
	
	@Column(length = 10, unique = true)
	private String registrationCode;
	
	private String manufacturer;
	
	private String model;
	
	private long flownHours;
	
	@OneToMany(mappedBy = "revisedAirplane")
	private List<Revision> revisions;
	
	@OneToMany(mappedBy = "airplane")
	private List<Flight> flights;
	
	private String revisionsJson;
	
	public Airplane() {}
	
	public Airplane(String registrationCode, String manufacturer, String model, long flownHours) {
		super();
		this.registrationCode = registrationCode;
		this.manufacturer = manufacturer;
		this.model = model;
		this.flownHours = flownHours;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Revision> getRevisions() {
		return revisions;
	}

	public void setRevisions(List<Revision> revisions) {
		this.revisions = revisions;
	}

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}

	public String getRevisionsJson() {
		return revisionsJson;
	}

	public void setRevisionsJson(String revisionsJson) {
		this.revisionsJson = revisionsJson;
	}

	@Override
	public String toString() {
		
		return "\tairplane_id: " + id + "\n" +
				"\tregistration_code: " + registrationCode + "\n" +
				"\tmanufacturer: " + manufacturer + "\n" +
				"\tmodel: " + model + "\n" +
				"\tflown_hours: " + flownHours;
	}

}
