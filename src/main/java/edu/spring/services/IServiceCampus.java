package edu.spring.services;

import java.util.List;

import edu.spring.model.Campus;

public interface IServiceCampus {
	public void save(Campus campus);
	public Campus findById(Long id);
	public void delete(Long id);
	public List<Campus> findAll();
}
