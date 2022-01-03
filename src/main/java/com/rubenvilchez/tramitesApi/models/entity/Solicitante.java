package com.rubenvilchez.tramitesApi.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@DiscriminatorValue(value = "solicitante")
@Entity
@Table(name="solicitantes")
public class Solicitante extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;


	public Solicitante() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Solicitante(Long id, String tipoIdentificacion, String identificacion, String nombres, String apellidos,
			Date fechaCreacion) {
		super(id, tipoIdentificacion, identificacion, nombres, apellidos, fechaCreacion);
		// TODO Auto-generated constructor stub
	}
	

	
}
