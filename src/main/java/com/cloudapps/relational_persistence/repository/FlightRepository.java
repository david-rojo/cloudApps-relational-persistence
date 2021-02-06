package com.cloudapps.relational_persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {

}
