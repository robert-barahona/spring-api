package edu.spring.controllers;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.spring.exceptions.BadRequestException;
import edu.spring.exceptions.ConflictException;
import edu.spring.exceptions.ErrorMessage;
import edu.spring.exceptions.ForbiddenExcepcion;
import edu.spring.exceptions.NotFoundException;
import edu.spring.exceptions.UnauthorizedException;
import edu.spring.model.Student;
import edu.spring.services.IServiceStudent;
import edu.spring.services.ServiceStudent;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private IServiceStudent service;
	
	public StudentController(IServiceStudent custDataAccess) {
		service = custDataAccess;
	}
	
	public void setCustomerDataAccess(IServiceStudent custDataAccess) {
		service = custDataAccess;
	}
	
	public StudentController() {
		service = new ServiceStudent();
	}
	
	@GetMapping("")
	public List<Student> findAll(){
		return service.findAll();
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Student save(@Valid @RequestBody Student student) {
		
		if(student.getLastName().split(" ").length > 2) {
			throw new BadRequestException("Debe ingresar dos apellidos");
		}
		
		service.save(student);
		return student;
		
	}
	
	@GetMapping("/{id}")
	public Student findById(@PathVariable(value="id") Long id) {
		
		if(id == 1) {
			throw new UnauthorizedException("No está autorizado a consultar este estudiante");
		}
		
		try {
			Student student = service.findById(id);
			
			return student;
		}catch(Exception ex) {
			throw new NotFoundException("No existe el estudiante con el id: " + id.toString());
		}
		
		
	
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Student update(@RequestBody Student student, @PathVariable Long id) {

		student.setIdStudent(id);
		
		if(id == 1) {
			throw new ConflictException("No puede editar este estudiante ");
		}
		
		service.save(student);
		return student;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id) {

		if(id == 1) {
			throw new ForbiddenExcepcion("Está prohibido eliminar al estudiante 1");
		}
		service.delete(id);
	}
	
	@GetMapping("/lastname/{lastName}")
	public List<Student> listByLastName(@PathVariable String lastName) {
		
		List<Student> students = service.searchByLastName(lastName);
		
		if(students.isEmpty()) {
			throw new NotFoundException("No existen estudiantes con el apellido: " + lastName);
		}
		
		return students;
		
	}
}
