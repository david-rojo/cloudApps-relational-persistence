package com.cloudapps.relational_persistence.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Revision {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private Airplane revisedAirplane;
	
	private Date startDate;
	
	private Date endDate;
	
	private double spentHours;
	
	private Mechanic mechanic;
	
	private String revisionType;
	
	private String description;
	
	private Airport airport;
	
	public Revision() {}
	
	public Revision(long id, Airplane revisedAirplane, Date startDate, Date endDate, double spentHours,
			Mechanic mechanic, String revisionType, String description, Airport airport) {
		super();
		this.id = id;
		this.revisedAirplane = revisedAirplane;
		this.startDate = startDate;
		this.endDate = endDate;
		this.spentHours = spentHours;
		this.mechanic = mechanic;
		this.revisionType = revisionType;
		this.description = description;
		this.airport = airport;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Airplane getRevisedAirplane() {
		return revisedAirplane;
	}

	public void setRevisedAirplane(Airplane revisedAirplane) {
		this.revisedAirplane = revisedAirplane;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getSpentHours() {
		return spentHours;
	}

	public void setSpentHours(double spentHours) {
		this.spentHours = spentHours;
	}

	public Mechanic getMechanic() {
		return mechanic;
	}

	public void setMechanic(Mechanic mechanic) {
		this.mechanic = mechanic;
	}

	public String getRevisionType() {
		return revisionType;
	}

	public void setRevisionType(String revisionType) {
		this.revisionType = revisionType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport airport) {
		this.airport = airport;
	}

	@Override
	public String toString() {
		return "Revision{" +
				"id=" + id + "," +
				"startDate='" + startDate + "'\'," +
				"endDate='" + endDate + "'\'," +
//				"revisedAirplane='" + revisedAirplane.toString() + "'\'," +
//				"airport='" + airport.toString() + "'\'," +
//				"mechanic='" + mechanic.toString() + "'\'," +
				"revisionType='" + revisionType + "'\'," +
				"spentHours=" + spentHours + 
				"description='" + description + "'\'," +
				'}';
	}

}
