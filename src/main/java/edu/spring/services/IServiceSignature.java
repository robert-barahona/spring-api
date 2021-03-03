package edu.spring.services;

import java.util.List;

import edu.spring.model.Signature;

public interface IServiceSignature {

	public void save(Signature signature);
	public Signature findById(Long id);
	public void delete(Long id);
	public List<Signature> findAll();
	
}
