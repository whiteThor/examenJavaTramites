package com.rubenvilchez.tramitesApi.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rubenvilchez.tramitesApi.models.entity.Tramite;
import com.rubenvilchez.tramitesApi.models.services.ITramiteService;

@RestController
@RequestMapping("/api/tramite")
@CrossOrigin(origins = {"http://localhost:4200","http://192.268.0.19:4200"})
public class TramiteRestController {
	
	
	@Autowired
	private ITramiteService tramiteService;

	@GetMapping("/")
	public List<Tramite> getAll(){
		return this.tramiteService.findAll();
	}
	
	@GetMapping("/{id}")
	public Tramite getById(@PathVariable Long id){
		return this.tramiteService.findByid(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Tramite create(@RequestBody Tramite tramite){
		return this.tramiteService.save(tramite);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Tramite update(@PathVariable Long id, @RequestBody Tramite tramite){
		Tramite tramiteBd = tramiteService.findByid(id);
		if(tramiteBd!= null) {
			tramiteBd.setDescripcionTramite(tramite.getDescripcionTramite());
			tramiteBd.setAnioRadicado(tramite.getAnioRadicado());
			tramiteBd.setSolicitante(tramite.getSolicitante());
			tramiteBd.setNombreTramite(tramite.getNombreTramite());
			tramiteBd.setNumeroRadicado(tramite.getNumeroRadicado());
			tramiteBd.setFuncionario(tramite.getFuncionario());

			
		}
		
		return this.tramiteService.save(tramiteBd);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		 this.tramiteService.delete(id);
		 
	}
	
}
