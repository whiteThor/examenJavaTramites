package com.rubenvilchez.tramitesApi.models.services;

import java.util.List;

import com.rubenvilchez.tramitesApi.models.entity.Persona;

public interface IPersonaService {
	
	public List<Persona> findAll();
	
	public Persona findByid(Long id);
	
	public Persona save(Persona persona);

	public void delete(long id);
}
