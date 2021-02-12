package com.cloudapps.relational_persistence.model.mysql;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * 
 * @author David Rojo Antona
 *
 */

@Embeddable
public class FlightCrewmemberId implements Serializable {
	
	private static final long serialVersionUID = -6310924530840168610L;

	private Long crewmemberId;
	
    private Long flightId;

    public FlightCrewmemberId() {}
    
	public FlightCrewmemberId(Long flightId, Long crewmemberId) {
		this.flightId = flightId;
		this.crewmemberId = crewmemberId;
	}

	public Long getFlightId() {
		return flightId;
	}

	public void setFlightId(Long flightId) {
		this.flightId = flightId;
	}

	public Long getCrewmemberId() {
		return crewmemberId;
	}

	public void setCrewmemberId(Long crewmemberId) {
		this.crewmemberId = crewmemberId;
	}  
    
}
