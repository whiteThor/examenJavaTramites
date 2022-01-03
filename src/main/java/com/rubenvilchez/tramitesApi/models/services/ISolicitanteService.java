package com.rubenvilchez.tramitesApi.models.services;

import java.util.List;

import com.rubenvilchez.tramitesApi.models.entity.Solicitante;

public interface ISolicitanteService {
	public List<Solicitante> findAll();
	
	public Solicitante findByid(Long id);
	
	public Solicitante save(Solicitante s);

	public void delete(long id);

}
