package com.cloudapps.relational_persistence.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.mysql.FlightCrewmember;

/**
 * 
 * @author David Rojo Antona
 *
 */

public interface FlightCrewmemberRepository extends JpaRepository<FlightCrewmember, Long> {

}
