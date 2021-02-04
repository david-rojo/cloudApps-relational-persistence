package com.cloudapps.persistencia_relacional.model;

import javax.persistence.Entity;

@Entity
public class Tripulante extends Empleado {
	
	private String puesto;
	
	private String companya;
	
	public Tripulante() {}

	public Tripulante(String codigoEmpleado, String nombre, String apellidos, String puesto, String companya) {
		super(codigoEmpleado, nombre, apellidos);
		this.puesto = puesto;
		this.companya = companya;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getCompanya() {
		return companya;
	}

	public void setCompanya(String companya) {
		this.companya = companya;
	}
	
	@Override
	public String toString() {
		return "Tripulante{" +
				"puesto='" + puesto + "'\'," +
				"companya='" + companya + "'\'," +
				'}';
	}	
	
}
