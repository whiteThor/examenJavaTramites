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

import com.rubenvilchez.tramitesApi.models.entity.Persona;
import com.rubenvilchez.tramitesApi.models.services.IPersonaService;


@RestController
@RequestMapping("/api/persona")
@CrossOrigin(origins = {"http://localhost:4200","http://192.268.0.19:4200"})
public class PersonaRestController {
	
	@Autowired
	private IPersonaService personaService;
	
	@GetMapping("/")
	public List<Persona> getAll(){
		return this.personaService.findAll();
	}
	
	@GetMapping("/{id}")
	public Persona getById(@PathVariable Long id){
		return this.personaService.findByid(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona create(@RequestBody Persona persona){
		return this.personaService.save(persona);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona update(@PathVariable Long id, @RequestBody Persona persona){
		Persona personaBd = personaService.findByid(id);
		if(personaBd!= null) {
			personaBd.setApellidos(persona.getApellidos());
			personaBd.setIdentificacion(persona.getIdentificacion());
			personaBd.setNombres(persona.getNombres());
			personaBd.setTipoIdentificacion(persona.getTipoIdentificacion());
			
		}
		
		return this.personaService.save(personaBd);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		 this.personaService.delete(id);
		 
	}
	

}
