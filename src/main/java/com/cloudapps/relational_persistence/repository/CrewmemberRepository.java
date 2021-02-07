package com.cloudapps.relational_persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cloudapps.relational_persistence.dto.DepartureCitiesAndDateFromEmployeeDTO;
import com.cloudapps.relational_persistence.model.Crewmember;

public interface CrewmemberRepository extends JpaRepository<Crewmember, Long> {

	@Query("SELECT new com.cloudapps.relational_persistence.dto.DepartureCitiesAndDateFromEmployeeDTO"
			+ "(c.name, c.surnames, a.city, a.iataCode, f.departureDateTime) " 
			+ "FROM Crewmember c "
			+ "JOIN FlightCrewmember fc ON c.id = fc.id.crewmemberId "
			+ "JOIN Flight f ON fc.id.flightId = f.id "
			+ "JOIN Airport a ON f.departure.id = a.id "
			+ "WHERE c.employeeCode = :employeeCode")
    List<DepartureCitiesAndDateFromEmployeeDTO> findDepartureCitiesAndDateByEmployeeCode(
    		@Param("employeeCode") String employeeCode);
}
