package com.rubenvilchez.tramitesApi.models.services;

import java.util.List;

import com.rubenvilchez.tramitesApi.models.entity.Empleado;

public interface IEmpleadoService {
	
	public List<Empleado> findAll();
	
	public Empleado findByid(Long id);
	
	public Empleado save(Empleado empleado);

	public void delete(long id);

}
