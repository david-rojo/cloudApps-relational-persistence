package com.cloudapps.relational_persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.relational_persistence.model.Mechanic;

public interface MechanicRepository extends JpaRepository<Mechanic, Long> {

}
