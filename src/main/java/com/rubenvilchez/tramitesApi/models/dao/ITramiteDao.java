package com.rubenvilchez.tramitesApi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.rubenvilchez.tramitesApi.models.entity.Tramite;

public interface ITramiteDao extends CrudRepository<Tramite, Long> {

}
