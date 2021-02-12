package com.cloudapps.relational_persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.Airport;

/**
 * 
 * @author David Rojo Antona
 *
 */

public interface AiportRepository extends JpaRepository<Airport, Long> {

}
