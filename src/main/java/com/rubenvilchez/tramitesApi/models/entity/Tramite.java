package com.rubenvilchez.tramitesApi.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Tramites")
public class Tramite  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long numeroRadicado;
	private String anioRadicado;
	private String nombreTramite;
	private String descripcionTramite;
	
	@OneToOne
	private Solicitante solicitante;
	
	@OneToOne
	private Empleado funcionario;
	
	@Temporal(TemporalType.DATE)
	private Date fechaCreacion;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getNumeroRadicado() {
		return numeroRadicado;
	}
	public void setNumeroRadicado(Long numeroRadicado) {
		this.numeroRadicado = numeroRadicado;
	}

	public String getNombreTramite() {
		return nombreTramite;
	}
	public void setNombreTramite(String nombreTramite) {
		this.nombreTramite = nombreTramite;
	}
	public String getDescripcionTramite() {
		return descripcionTramite;
	}
	public void setDescripcionTramite(String descripcionTramite) {
		this.descripcionTramite = descripcionTramite;
	}

	public Solicitante getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Solicitante solicitante) {
		this.solicitante = solicitante;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	@PrePersist
	private void prePersist() {
		this.fechaCreacion= new Date();
	}
	
	public String getAnioRadicado() {
		return anioRadicado;
	}
	public void setAnioRadicado(String anioRadicado) {
		this.anioRadicado = anioRadicado;
	}
	public Empleado getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Empleado funcionario) {
		this.funcionario = funcionario;
	}
	
}
