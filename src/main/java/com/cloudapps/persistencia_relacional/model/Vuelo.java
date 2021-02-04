package com.cloudapps.persistencia_relacional.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Vuelo {

	@Id
	private String codigoVuelo;
	
	private String companya;
	
	private Avion avion;
	
	private Aeropuerto origen;
	
	private Aeropuerto destino;
	
	private Date fechaHoraSalida;
	
	private double duracion;
	
	private List<Tripulante> tripulantes;
	
	public Vuelo() {}

	public Vuelo(String codigoVuelo, String companya, Avion avion, Aeropuerto origen, Aeropuerto destino,
			Date fechaHoraSalida, double duracion, List<Tripulante> tripulantes) {
		super();
		this.codigoVuelo = codigoVuelo;
		this.companya = companya;
		this.avion = avion;
		this.origen = origen;
		this.destino = destino;
		this.fechaHoraSalida = fechaHoraSalida;
		this.duracion = duracion;
		this.tripulantes = tripulantes;
	}

	public String getCodigoVuelo() {
		return codigoVuelo;
	}

	public void setCodigoVuelo(String codigoVuelo) {
		this.codigoVuelo = codigoVuelo;
	}

	public String getCompanya() {
		return companya;
	}

	public void setCompanya(String companya) {
		this.companya = companya;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public Aeropuerto getOrigen() {
		return origen;
	}

	public void setOrigen(Aeropuerto origen) {
		this.origen = origen;
	}

	public Aeropuerto getDestino() {
		return destino;
	}

	public void setDestino(Aeropuerto destino) {
		this.destino = destino;
	}

	public Date getFechaHoraSalida() {
		return fechaHoraSalida;
	}

	public void setFechaHoraSalida(Date fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}

	public double getDuracion() {
		return duracion;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public List<Tripulante> getTripulantes() {
		return tripulantes;
	}

	public void setTripulantes(List<Tripulante> tripulantes) {
		this.tripulantes = tripulantes;
	}
	
	@Override
	public String toString() {
		return "Vuelo{" +
				"codigoVuelo='" + codigoVuelo + "'\'," +
				"companya='" + companya + "'\'," +
//				"avion='" + avion.toString() + "'\'," +
//				"origen='" + origen.toString() + "'\'," +
//				"destino='" + destino.toString() + "'\'," +
				"fechaHoraSalida='" + fechaHoraSalida + "'\'," +
				"duracion=" + duracion + 
//				"tripulantes='" + tripulantes + "'\'," +
				'}';
	}
	
}
