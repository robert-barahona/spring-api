package edu.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.Transactional;

import edu.spring.model.Student;
import edu.spring.repositories.IStudentRepository;

@Service
public class ServiceStudent implements IServiceStudent {
	
	@Autowired
	private IStudentRepository dao;

	@Override
	public void save(Student student) {
		dao.save(student);
	}

	@Override
	public Student findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public List<Student> findAll() {
		return (List<Student>)dao.findAll();
	}
	
	@Override
    @Transactional(readOnly=true)
    public List<Student> searchByLastName(String a) {
        return dao.findByLastNameContains(a);
    }
	
}
