package com.cloudapps.persistencia_relacional.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Avion {

	@Id
	private String matricula;
	
	private String fabricante;
	
	private String modelo;
	
	private long horasDeVuelo;
	
	public Avion() {}

	
	public Avion(String matricula, String fabricante, String modelo, long horasDeVuelo) {
		super();
		this.matricula = matricula;
		this.fabricante = fabricante;
		this.modelo = modelo;
		this.horasDeVuelo = horasDeVuelo;
	}


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public long getHorasDeVuelo() {
		return horasDeVuelo;
	}

	public void setHorasDeVuelo(long horasDeVuelo) {
		this.horasDeVuelo = horasDeVuelo;
	}

	@Override
	public String toString() {
		return "Avion{" +
				"matricula='" + matricula + "'\'," +
				"fabricante='" + fabricante + "'\'," +
				"modelo='" + modelo + "'\'," +
				"horasDeVuelo=" + horasDeVuelo + 
				'}';
	}

}
