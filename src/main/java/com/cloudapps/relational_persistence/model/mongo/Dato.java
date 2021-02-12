package com.cloudapps.relational_persistence.model.mongo;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * 
 * @author David Rojo Antona
 *
 */

public class Dato {

	@Field("Anyo")
	private String anyo;
	
	@Field("Valor")
	private Long valor;
	
	public Dato() {}

	public Dato(String anyo, Long valor) {
		super();
		this.anyo = anyo;
		this.valor = valor;
	}

	public String getAnyo() {
		return anyo;
	}

	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Dato{" 
				+ "anyo=" + anyo + ", " 
				+ "valor=" + valor +
				"}";
	}

}
