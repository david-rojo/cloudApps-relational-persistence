package com.cloudapps.persistencia_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.persistencia_relacional.model.Aeropuerto;

public interface AeropuertoRepository extends JpaRepository<Aeropuerto, String> {

}
