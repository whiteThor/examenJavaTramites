package com.rubenvilchez.tramitesApi.models.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubenvilchez.tramitesApi.models.dao.IEmpleadoDao;
import com.rubenvilchez.tramitesApi.models.entity.Empleado;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

	@Autowired
	private IEmpleadoDao empleadoDao;
	
	@Override
	@Transactional(readOnly = false)
	public List<Empleado> findAll() {
		
		return (List<Empleado>) this.empleadoDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Empleado findByid(Long id) {
		return this.empleadoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Empleado save(Empleado empleado) {
		return this.empleadoDao.save(empleado);
	}

	@Override
	@Transactional
	public void delete(long id) {
		this.empleadoDao.deleteById(id);
	}

}
