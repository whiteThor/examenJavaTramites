package com.rubenvilchez.tramitesApi.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.rubenvilchez.tramitesApi.models.entity.Empleado;

public interface IEmpleadoDao extends CrudRepository<Empleado, Long> {

}
