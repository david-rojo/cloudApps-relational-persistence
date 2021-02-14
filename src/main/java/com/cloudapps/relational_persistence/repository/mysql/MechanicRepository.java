package com.cloudapps.relational_persistence.repository.mysql;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cloudapps.relational_persistence.dto.mysql.MechanicPerAirplaneDTO;
import com.cloudapps.relational_persistence.model.mysql.Mechanic;

/**
 * 
 * @author David Rojo Antona
 *
 */

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

	@Query("SELECT new com.cloudapps.relational_persistence.dto.mysql.MechanicPerAirplaneDTO" 
			+ "(r.revisedAirplane.registrationCode, m.name, m.surnames)" 
			+ "FROM Mechanic m "
			+ "JOIN Revision r ON m.id = r.mechanic.id")
    List<MechanicPerAirplaneDTO> findMechanicsPerAirplane();
	
	@Query("SELECT new com.cloudapps.relational_persistence.dto.mysql.MechanicPerAirplaneDTO" 
			+ "(a.registrationCode, m.name, m.surnames)" 
			+ "FROM Mechanic m "
			+ "JOIN Airplane a ON FUNCTION('JSON_CONTAINS',"
			+ "FUNCTION('JSON_EXTRACT', a.revisionsJson, '$[*].\"employee_id\"'),"
			+ "FUNCTION('CONVERT', m.id, JSON)) = 1")
    List<MechanicPerAirplaneDTO> findMechanicsPerAirplanePractice2();
}
