package com.cloudapps.persistencia_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.persistencia_relacional.model.Tripulante;

public interface TripulanteRepository extends JpaRepository<Tripulante, String> {

}
