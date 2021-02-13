package com.cloudapps.relational_persistence.dto.mongo;

public class GroupByComunidadAndCountDTO {
	
	private String comunidad;
	
	private int provincias;
	
	public GroupByComunidadAndCountDTO() {}

	public GroupByComunidadAndCountDTO(String comunidad, int provincias) {
		super();
		this.comunidad = comunidad;
		this.provincias = provincias;
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	public int getProvincias() {
		return provincias;
	}

	public void setProvincias(int provincias) {
		this.provincias = provincias;
	}
	
	@Override
	public String toString() {
		return "GroupByComunidadAndCountDTO{" 
				+ "comunidad='" + comunidad + "', " 
				+ "provincias=" + provincias +
				"}";
	}

}
