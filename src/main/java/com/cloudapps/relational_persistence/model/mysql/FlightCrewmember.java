package com.cloudapps.relational_persistence.model.mysql;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

/**
 * 
 * @author David Rojo Antona
 *
 */

@Entity
@Table(name="flight_crewmember")
public class FlightCrewmember {

	@EmbeddedId
	private FlightCrewmemberId id;
	
	@ManyToOne
    @MapsId("crewmemberId")
    private Crewmember crewmember;
	
	@ManyToOne
    @MapsId("flightId")
    private Flight flight;
	
	public FlightCrewmember() {}

	public FlightCrewmember(Flight flight, Crewmember crewmember) {
		this.crewmember = crewmember;
		this.flight = flight;
		// Following line create composite key:
        this.id = new FlightCrewmemberId(flight.getId(), crewmember.getId());
	}

	public FlightCrewmemberId getId() {
		return id;
	}

	public void setId(FlightCrewmemberId id) {
		this.id = id;
	}

	public Crewmember getCrewmember() {
		return crewmember;
	}

	public void setCrewmember(Crewmember crewmember) {
		this.crewmember = crewmember;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}	
	
}
