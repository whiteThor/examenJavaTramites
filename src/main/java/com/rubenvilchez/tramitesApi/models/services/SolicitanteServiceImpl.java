package com.rubenvilchez.tramitesApi.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rubenvilchez.tramitesApi.models.dao.ISolicitanteDao;
import com.rubenvilchez.tramitesApi.models.entity.Solicitante;
@Service
public class SolicitanteServiceImpl implements ISolicitanteService{

	@Autowired
	private ISolicitanteDao solicitanteDao;
	
	@Override
	@Transactional(readOnly = false)
	public List<Solicitante> findAll() {
		
		return (List<Solicitante>) this.solicitanteDao.findAll();
	}

	@Override
	@Transactional(readOnly = false)
	public Solicitante findByid(Long id) {
		return this.solicitanteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional(noRollbackFor = Exception.class)
	public Solicitante save(Solicitante solicitante) {
		return this.solicitanteDao.save(solicitante);
	}

	@Override
	@Transactional
	public void delete(long id) {
		this.solicitanteDao.deleteById(id);
	}


}
