package com.cloudapps.relational_persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cloudapps.relational_persistence.dto.MechanicPerAirplaneDTO;
import com.cloudapps.relational_persistence.model.Mechanic;

/**
 * 
 * @author David Rojo Antona
 *
 */

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

	@Query("SELECT DISTINCT new com.cloudapps.relational_persistence.dto.MechanicPerAirplaneDTO" 
			+ "(r.revisedAirplane.registrationCode, m.name, m.surnames)" 
			+ "FROM Mechanic m "
			+ "JOIN Revision r ON m.id = r.mechanic.id")
    List<MechanicPerAirplaneDTO> findMechanicsPerAirplane();
}
