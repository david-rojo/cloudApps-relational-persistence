package com.cloudapps.persistencia_relacional.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cloudapps.persistencia_relacional.model.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

}
