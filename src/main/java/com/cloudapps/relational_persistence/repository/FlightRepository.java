package com.cloudapps.relational_persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cloudapps.relational_persistence.dto.FlightsByArrivalAndDateDTO;
import com.cloudapps.relational_persistence.dto.FlightStatisticsFromCrewmemberDTO;
import com.cloudapps.relational_persistence.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

	@Query("SELECT new com.cloudapps.relational_persistence.dto.FlightsByArrivalAndDateDTO"
			+ "(f.flightCode, f.company, f.departure.city, f.departure.iataCode, f.arrival.city, f.arrival.iataCode,"
			+ " f.departureDateTime, f.duration)" 
			+ " FROM Flight f"
			+ " JOIN Airport a ON f.arrival.id = a.id"
			+ " WHERE a.city LIKE :arrivalCity"
            	+ " AND FUNCTION('date_format', f.departureDateTime, '%d-%m-%Y') = :requestDate"
            + " ORDER BY FUNCTION('date_format', f.departureDateTime, '%H')")
    List<FlightsByArrivalAndDateDTO> findFlightsByArrivalAndDate(
    		@Param("arrivalCity") String arrivalCity,
    		@Param("requestDate") String requestDate);
	
    @Query("SELECT new com.cloudapps.relational_persistence.dto.FlightStatisticsFromCrewmemberDTO"
    		+ "(c.name, c.surnames, COUNT(f.id), SUM(f.duration))"
    		+ " FROM Crewmember c"
    		+ " JOIN FlightCrewmember fc ON c.id = fc.id.crewmemberId"
    		+ " JOIN Flight f ON fc.id.flightId = f.id"
    		+ " GROUP BY c.name, c.surnames")
    List<FlightStatisticsFromCrewmemberDTO> findFlightStatistics();
	
}
