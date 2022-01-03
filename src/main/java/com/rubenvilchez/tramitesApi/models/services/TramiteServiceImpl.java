package com.rubenvilchez.tramitesApi.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubenvilchez.tramitesApi.models.dao.ITramiteDao;
import com.rubenvilchez.tramitesApi.models.entity.Tramite;

@Service
public class TramiteServiceImpl implements ITramiteService{

	@Autowired
	private ITramiteDao tramiteDao;
	
	@Override
	@Transactional(readOnly = false)
	public List<Tramite> findAll() {
		return (List<Tramite>) this.tramiteDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Tramite findByid(Long id) {
		return this.tramiteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Tramite save(Tramite tramite) {
		return this.tramiteDao.save(tramite);
	}

	@Override
	@Transactional
	public void delete(long id) {
		this.tramiteDao.deleteById(id);
		
	}

}
