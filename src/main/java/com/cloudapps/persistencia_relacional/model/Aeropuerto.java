package com.cloudapps.persistencia_relacional.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import javax.validation.constraints.Size;

@Entity
public class Aeropuerto {

	@Id
	@Column(length = 3)
    @Size(min = 3, max = 3)
	private String codigoIATA;
	
	private String nombre;
	
	private String ciudad;
	
	private String pais;
	
	public Aeropuerto() {}

	public Aeropuerto(String codigoIATA, String nombre, String ciudad, String pais) {
		super();
		this.codigoIATA = codigoIATA;
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public String getCodigoIATA() {
		return codigoIATA;
	}

	public void setCodigoIATA(String codigoIATA) {
		this.codigoIATA = codigoIATA;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return "Aeropuerto{" +
				"codigoIATA='" + codigoIATA + "'\'," +
				"nombre='" + nombre + "'\'," +
				"ciudad='" + ciudad + "'\'," +
				"pais='" + pais + "'\'" + 
				'}';
	}
	
}
