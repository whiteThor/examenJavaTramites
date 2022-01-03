package com.rubenvilchez.tramitesApi.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubenvilchez.tramitesApi.models.dao.IPersonaDao;
import com.rubenvilchez.tramitesApi.models.entity.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaDao personaDao;

	@Override
	@Transactional(readOnly = false)
	public List<Persona> findAll() {
		
		return (List<Persona>) this.personaDao.findAll();
		
	}

	@Override
	@Transactional(readOnly = false)
	public Persona findByid(Long id) {
		
		return this.personaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		
		return this.personaDao.save(persona);
	}

	@Override
	@Transactional
	public void delete(long id) {
		this.personaDao.deleteById(id);
		
		
	}

}
