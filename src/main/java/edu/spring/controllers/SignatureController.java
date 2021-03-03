package edu.spring.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.spring.exceptions.NotFoundException;
import edu.spring.model.Signature;
import edu.spring.model.Student;
import edu.spring.services.IServiceSignature;
import edu.spring.services.ServiceSignature;

@RestController
@RequestMapping("/api/signature")
public class SignatureController {
	
	@Autowired
	private IServiceSignature service;
	
	public SignatureController() {
		service = new ServiceSignature();
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Signature save(@Valid @RequestBody Signature signature) {
		service.save(signature);
		return signature;
	}
	
	@GetMapping("")
	public List<Signature> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Signature findById(@PathVariable(value="id") Long id) {
		
		try {
			Signature signature = service.findById(id);
			return signature;
		}catch(Exception ex) {
			throw new NotFoundException("No existe el Signature con el id: " + id.toString());
		}
	
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Signature update(@RequestBody Signature signature, @PathVariable Long id) {
		signature.setIdSignature(id);
		service.save(signature);
		return signature;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}

}
