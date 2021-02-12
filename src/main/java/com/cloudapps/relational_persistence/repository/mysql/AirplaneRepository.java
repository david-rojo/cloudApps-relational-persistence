package com.cloudapps.relational_persistence.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.mysql.Airplane;

/**
 * 
 * @author David Rojo Antona
 *
 */

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

}
