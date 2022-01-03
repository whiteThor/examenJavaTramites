package com.rubenvilchez.tramitesApi.models.services;

import java.util.List;

import com.rubenvilchez.tramitesApi.models.entity.Tramite;

public interface ITramiteService {
	
	public List<Tramite> findAll();
	
	public Tramite findByid(Long id);
	
	public Tramite save(Tramite tramite);

	public void delete(long id);

}
