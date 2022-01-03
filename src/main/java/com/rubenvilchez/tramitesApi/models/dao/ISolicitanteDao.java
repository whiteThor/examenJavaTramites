package com.rubenvilchez.tramitesApi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.rubenvilchez.tramitesApi.models.entity.Solicitante;

public interface ISolicitanteDao extends CrudRepository<Solicitante, Long>{

}
