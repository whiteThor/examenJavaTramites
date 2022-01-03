package com.rubenvilchez.tramitesApi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.rubenvilchez.tramitesApi.models.entity.Persona;

public interface IPersonaDao extends CrudRepository<Persona, Long>{

}
