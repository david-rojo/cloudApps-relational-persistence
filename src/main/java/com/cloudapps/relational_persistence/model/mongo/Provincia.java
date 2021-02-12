package com.cloudapps.relational_persistence.model.mongo;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 
 * @author David Rojo Antona
 *
 */

public class Provincia {

	@Id
	private String id;
	
	@Field("Nombre")
	private String nombre;
	
	@Field("CA")
	private String comunidadAutonoma;
	
	@Field("Superficie")
	private int superficie;
	
	@Field("Datos")
	private List<Dato> datos;
	
	public Provincia() {}

	public Provincia(String nombre, String comunidadAutonoma, int superficie, List<Dato> datos) {
		super();
		this.nombre = nombre;
		this.comunidadAutonoma = comunidadAutonoma;
		this.superficie = superficie;
		this.datos = datos;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(String comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}

	public List<Dato> getDatos() {
		return datos;
	}

	public void setDatos(List<Dato> datos) {
		this.datos = datos;
	}
	
	@Override
    public String toString() {
        return String.format(
                "Provincia{id=%s, Nombre='%s', CA='%s', Superficie=%s, Datos='%s'}",
                id, nombre, comunidadAutonoma, superficie, datos);
    }
	
}
