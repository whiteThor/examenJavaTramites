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

import com.rubenvilchez.tramitesApi.models.entity.Solicitante;
import com.rubenvilchez.tramitesApi.models.services.ISolicitanteService;

@RestController
@RequestMapping("/api/solicitante")
@CrossOrigin(origins = {"http://localhost:4200","http://192.268.0.19:4200"})
public class SolicitanteRestController {

	@Autowired
	private ISolicitanteService solicitanteService;
	
	@GetMapping("/")
	public List<Solicitante> getAll(){
		return this.solicitanteService.findAll();
	}
	
	@GetMapping("/{id}")
	public Solicitante getById(@PathVariable Long id){
		return this.solicitanteService.findByid(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Solicitante create(@RequestBody Solicitante empleado){
		return this.solicitanteService.save(empleado);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Solicitante update(@PathVariable Long id, @RequestBody Solicitante empleado){
		Solicitante empleadoBd = solicitanteService.findByid(id);
		if(empleadoBd!= null) {
			empleadoBd.setApellidos(empleado.getApellidos());
			empleadoBd.setIdentificacion(empleado.getIdentificacion());
			empleadoBd.setNombres(empleado.getNombres());
			empleadoBd.setTipoIdentificacion(empleado.getTipoIdentificacion());
	

		}
		
		return this.solicitanteService.save(empleadoBd);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		 this.solicitanteService.delete(id);
		 
	}
}
