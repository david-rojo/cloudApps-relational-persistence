package com.cloudapps.relational_persistence.repository.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cloudapps.relational_persistence.dto.FlightsByArrivalAndDateDTO;
import com.cloudapps.relational_persistence.model.mysql.Flight;

/**
 * 
 * @author David Rojo Antona
 *
 */

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("SELECT new com.cloudapps.relational_persistence.dto.FlightsByArrivalAndDateDTO"
			+ "(f.flightCode, f.company, f.departure.city, f.departure.iataCode, f.arrival.city, f.arrival.iataCode,"
			+ " f.departureDateTime, f.duration)" 
			+ " FROM Flight f"
			+ " JOIN Airport a ON f.arrival.id = a.id"
			+ " WHERE a.city LIKE :arrivalCity"
            	+ " AND FUNCTION('date_format', f.departureDateTime, '%d-%m-%Y') = :requestDate"
            + " ORDER BY f.departureDateTime ASC")
    List<FlightsByArrivalAndDateDTO> findFlightsByArrivalAndDate(
    		@Param("arrivalCity") String arrivalCity,
    		@Param("requestDate") String requestDate);
	
}
