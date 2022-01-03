package com.rubenvilchez.tramitesApi.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="empleados")
@DiscriminatorValue(value = "empleado")
public class Empleado extends Persona implements Serializable{
	private static final long serialVersionUID = 1L;
		

	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleado(Long id, String tipoIdentificacion, String identificacion, String nombres, String apellidos,
			Date fechaCreacion) {
		super(id, tipoIdentificacion, identificacion, nombres, apellidos, fechaCreacion);
		// TODO Auto-generated constructor stub
	}

	private String dependencia;
	
	@Temporal(TemporalType.DATE)
	private Date fechaIngreso;

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	
}
