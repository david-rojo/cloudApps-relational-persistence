package com.cloudapps.persistencia_relacional.model;

import javax.persistence.Entity;

@Entity
public class Mecanico extends Empleado {

	private String empresa;
	
	private int anyoIncorporacion;
	
	private String formacionPrevia;
	
	public Mecanico(String codigoEmpleado, String nombre, String apellidos, String empresa, int anyoIncorporacion,
			String formacionPrevia) {
		super(codigoEmpleado, nombre, apellidos);
		this.empresa = empresa;
		this.anyoIncorporacion = anyoIncorporacion;
		this.formacionPrevia = formacionPrevia;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getAnyoIncorporacion() {
		return anyoIncorporacion;
	}

	public void setAnyoIncorporacion(int anyoIncorporacion) {
		this.anyoIncorporacion = anyoIncorporacion;
	}

	public String getFormacionPrevia() {
		return formacionPrevia;
	}

	public void setFormacionPrevia(String formacionPrevia) {
		this.formacionPrevia = formacionPrevia;
	}
	
	@Override
	public String toString() {
		return "Mecanico{" +
				"empresa='" + empresa + "'\'," +
				"formacionPrevia='" + formacionPrevia + "'\'," +
				"anyoIncorporacion=" + anyoIncorporacion + 
				'}';
	}
	
}
