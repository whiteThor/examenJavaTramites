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

import com.rubenvilchez.tramitesApi.models.entity.Empleado;
import com.rubenvilchez.tramitesApi.models.services.IEmpleadoService;

@RestController
@RequestMapping("/api/empleado")
@CrossOrigin(origins = {"http://localhost:4200","http://192.268.0.19:4200"})
public class EmpleadoRestController {

	@Autowired
	private IEmpleadoService empleadoService;
	
	@GetMapping("/")
	public List<Empleado> getAll(){
		return this.empleadoService.findAll();
	}
	
	@GetMapping("/{id}")
	public Empleado getById(@PathVariable Long id){
		return this.empleadoService.findByid(id);
	}
	
	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado create(@RequestBody Empleado empleado){
		return this.empleadoService.save(empleado);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Empleado update(@PathVariable Long id, @RequestBody Empleado empleado){
		Empleado empleadoBd = empleadoService.findByid(id);
		if(empleadoBd!= null) {
			empleadoBd.setApellidos(empleado.getApellidos());
			empleadoBd.setIdentificacion(empleado.getIdentificacion());
			empleadoBd.setNombres(empleado.getNombres());
			empleadoBd.setTipoIdentificacion(empleado.getTipoIdentificacion());
			empleadoBd.setDependencia(empleado.getDependencia());
			empleadoBd.setFechaIngreso(empleado.getFechaIngreso());

		}
		
		return this.empleadoService.save(empleadoBd);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		 this.empleadoService.delete(id);
		 
	}
	
}
