package com.cloudapps.persistencia_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.persistencia_relacional.model.Vuelo;

public interface VueloRepository extends JpaRepository<Vuelo, String> {

}
