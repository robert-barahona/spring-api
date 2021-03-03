package edu.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.model.Campus;
import edu.spring.repositories.ICampusRepository;

@Service
public class ServiceCampus implements IServiceCampus {
	
	@Autowired
	private ICampusRepository dao;

	@Override
	public void save(Campus campus) {
		dao.save(campus);
	}

	@Override
	public Campus findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public List<Campus> findAll() {
		return (List<Campus>)dao.findAll();
	}

}
