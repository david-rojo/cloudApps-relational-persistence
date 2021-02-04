package com.cloudapps.persistencia_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.persistencia_relacional.model.Avion;

public interface AvionRepository extends JpaRepository<Avion, String> {

}
