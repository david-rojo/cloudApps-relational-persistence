package com.cloudapps.persistencia_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.persistencia_relacional.model.Mecanico;

public interface MecanicoRepository extends JpaRepository<Mecanico, String> {

}
