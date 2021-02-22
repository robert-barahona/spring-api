package edu.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import edu.spring.model.Student;
import edu.spring.services.IServiceStudent;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private IServiceStudent service;
	
	@GetMapping("")
	public List<Student> findAll(){
		return service.findAll();
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public Student save(@RequestBody Student student) {
		service.save(student);
		return student;
	}
	
	@GetMapping("/{id}")
	public Student retrieve(@PathVariable(value="id") Long id) {
		return service.findById(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Student update(@RequestBody Student student, @PathVariable Long id) {
		student.setIdStudent(id);
		service.save(student);
		return student;
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable Long id) {
		service.delete(id);
	}
	
	@GetMapping("/lastname/{lastName}")
	public List<Student> listByLastName(@PathVariable String lastName) {
		return service.searchByLastName(lastName);
	}
}
