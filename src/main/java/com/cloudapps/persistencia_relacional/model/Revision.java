package com.cloudapps.persistencia_relacional.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Revision {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	private Avion avionRevisado;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private double horasEmpleadas;
	
	private Mecanico mecanico;
	
	private String tipoRevision;
	
	private String descripcion;
	
	private Aeropuerto aeropuerto;
	
	public Revision() {}
	
	public Revision(long id, Avion avionRevisado, Date fechaInicio, Date fechaFin, double horasEmpleadas,
			Mecanico mecanico, String tipoRevision, String descripcion, Aeropuerto aeropuerto) {
		super();
		this.id = id;
		this.avionRevisado = avionRevisado;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.horasEmpleadas = horasEmpleadas;
		this.mecanico = mecanico;
		this.tipoRevision = tipoRevision;
		this.descripcion = descripcion;
		this.aeropuerto = aeropuerto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Avion getAvionRevisado() {
		return avionRevisado;
	}

	public void setAvionRevisado(Avion avionRevisado) {
		this.avionRevisado = avionRevisado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getHorasEmpleadas() {
		return horasEmpleadas;
	}

	public void setHorasEmpleadas(double horasEmpleadas) {
		this.horasEmpleadas = horasEmpleadas;
	}

	public Mecanico getMecanico() {
		return mecanico;
	}

	public void setMecanico(Mecanico mecanico) {
		this.mecanico = mecanico;
	}

	public String getTipoRevision() {
		return tipoRevision;
	}

	public void setTipoRevision(String tipoRevision) {
		this.tipoRevision = tipoRevision;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Aeropuerto getAeropuerto() {
		return aeropuerto;
	}

	public void setAeropuerto(Aeropuerto aeropuerto) {
		this.aeropuerto = aeropuerto;
	}
	
	@Override
	public String toString() {
		return "Revision{" +
				"id=" + id + "," +
				"fechaInicio='" + fechaInicio + "'\'," +
				"fechaFin='" + fechaFin + "'\'," +
//				"avionRevisado='" + avionRevisado.toString() + "'\'," +
//				"aeropuerto='" + aeropuerto.toString() + "'\'," +
//				"mecanico='" + mecanico.toString() + "'\'," +
				"tipoRevision='" + tipoRevision + "'\'," +
				"horasEmpleadas=" + horasEmpleadas + 
				"descripcion='" + descripcion + "'\'," +
				'}';
	}

}
