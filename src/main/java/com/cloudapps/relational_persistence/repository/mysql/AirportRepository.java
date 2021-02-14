package com.cloudapps.relational_persistence.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.mysql.Airport;

/**
 * 
 * @author David Rojo Antona
 *
 */

public interface AirportRepository extends JpaRepository<Airport, Long> {

}
