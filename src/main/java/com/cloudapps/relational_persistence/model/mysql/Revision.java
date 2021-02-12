package com.cloudapps.relational_persistence.model;

import static com.cloudapps.relational_persistence.configuration.Constants.DATE_FORMAT;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author David Rojo Antona
 *
 */

@Entity
@Table(name="revision")
public class Revision {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private Date startDate;
	
	private Date endDate;
	
	private double spentHours;
	
	private String revisionType;
	
	private String description;
	
	@ManyToOne
    @JoinColumn(name = "aiport_id", nullable=false)
	private Airport revisionAirport;
	
	@ManyToOne
	@JoinColumn(name = "airplane_id", nullable=false)
	private Airplane revisedAirplane;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable=false)
	private Mechanic mechanic;
	
	
	public Revision() {}
	
	public Revision(Airplane revisedAirplane, Date startDate, Date endDate, double spentHours,
			Mechanic mechanic, String revisionType, String description, Airport revisionAirport) {
		super();
		this.revisedAirplane = revisedAirplane;
		this.startDate = startDate;
		this.endDate = endDate;
		this.spentHours = spentHours;
		this.mechanic = mechanic;
		this.revisionType = revisionType;
		this.description = description;
		this.revisionAirport = revisionAirport;
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

	public Airport getRevisionAirport() {
		return revisionAirport;
	}

	public void setRevisionAirport(Airport revisionAirport) {
		this.revisionAirport = revisionAirport;
	}

	@Override
	public String toString() {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		return "\tid: " + id + "\n" +
				"\trevision_type: " + revisionType + "\n" +
				"\tdescription: " + description + "\n" +
				"\tstart_date: " + simpleDateFormat.format(startDate)+ "\n" +
				"\tend_date: " + simpleDateFormat.format(endDate)+ "\n" +
				"\tspent_hours: " + spentHours + "\n" +
				"\temployee_id: " + mechanic.getId()+ "\n" +
				"\tairplane_id: " + revisedAirplane.getId()+ "\n" +
				"\tairport_id: " + revisionAirport.getId();
	}

}
