package edu.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import edu.spring.exceptions.NotFoundException;
import edu.spring.model.Campus;
import edu.spring.services.IServiceCampus;
import edu.spring.services.ServiceCampus;

@RestController
@RequestMapping("/api/campus")
public class CampusController {
	
	@Autowired
	private IServiceCampus service;
	
	public CampusController() {
		service = new ServiceCampus();
	}
	
	@GetMapping("")
	public List<Campus> findAll(){
		return service.findAll();
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Campus save(@Valid @RequestBody Campus campus) {
		service.save(campus);
		return campus;
	}
	
	@GetMapping("/{id}")
	public Campus findById(@PathVariable(value="id") Long id) {
		
		try {
			Campus campus = service.findById(id);
			return campus;
		}catch(Exception ex) {
			throw new NotFoundException("No existe el campus con el id: " + id.toString());
		}
	
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Campus update(@RequestBody Campus campus, @PathVariable Long id) {
		campus.setIdCampus(id);
		service.save(campus);
		return campus;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
