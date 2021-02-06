package com.cloudapps.relational_persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.Airplane;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

}
