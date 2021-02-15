package com.cloudapps.relational_persistence.repository.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cloudapps.relational_persistence.dto.mysql.DepartureCitiesAndDateFromEmployeeDTO;
import com.cloudapps.relational_persistence.dto.mysql.FlightStatisticsFromCrewmemberDTO;
import com.cloudapps.relational_persistence.model.mysql.Crewmember;

/**
 * 
 * @author David Rojo Antona
 *
 */

public interface CrewmemberRepository extends JpaRepository<Crewmember, Long> {

	@Query("SELECT new com.cloudapps.relational_persistence.dto.mysql.DepartureCitiesAndDateFromEmployeeDTO"
			+ "(c.name, c.surnames, a.city, a.iataCode, f.departureDateTime) " 
			+ "FROM Crewmember c "
			+ "JOIN FlightCrewmember fc ON c.id = fc.id.crewmemberId "
			+ "JOIN Flight f ON fc.id.flightId = f.id "
			+ "JOIN Airport a ON f.departure.id = a.id "
			+ "WHERE c.employeeCode = :employeeCode")
    List<DepartureCitiesAndDateFromEmployeeDTO> findDepartureCitiesAndDateByEmployeeCode(
    		@Param("employeeCode") String employeeCode);
	
	@Query("SELECT new com.cloudapps.relational_persistence.dto.mysql.FlightStatisticsFromCrewmemberDTO"
    		+ "(c.name, c.surnames, COUNT(f.id), SUM(f.duration))"
    		+ " FROM Crewmember c"
    		+ " JOIN FlightCrewmember fc ON c.id = fc.id.crewmemberId"
    		+ " JOIN Flight f ON fc.id.flightId = f.id"
    		+ " GROUP BY c.name, c.surnames")
    List<FlightStatisticsFromCrewmemberDTO> findFlightStatistics();
	
	@Query("SELECT new com.cloudapps.relational_persistence.dto.mysql.FlightStatisticsFromCrewmemberDTO"
    		+ "(c.name, c.surnames, COUNT(f.id), SUM(f.duration))"
    		+ " FROM Crewmember c"
    		+ " JOIN Flight f ON FUNCTION('JSON_CONTAINS',"
    		+ " FUNCTION('JSON_EXTRACT', f.crewJson ,'$[*].employee_code'),"
    		+ " CONVERT(c.id, JSON)) = 1"
    		+ " GROUP BY c.name, c.surnames")
    List<FlightStatisticsFromCrewmemberDTO> findFlightStatisticsByJSON();

}
