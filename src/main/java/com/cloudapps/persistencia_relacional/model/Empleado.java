package com.cloudapps.persistencia_relacional.model;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Empleado {

	@Id
	private String codigoEmpleado;

	private String nombre;
	
	private String apellidos;
	
	public Empleado() {}

	public Empleado(String codigoEmpleado, String nombre, String apellidos) {
		super();
		this.codigoEmpleado = codigoEmpleado;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Persona{" +
				"codigoEmpleado='" + codigoEmpleado + "'\'," +
				"nombre='" + nombre + "'\'," +
				"apellidos='" + apellidos + "'\'," +
				'}';
	}
}
