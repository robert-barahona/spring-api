package edu.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.spring.model.Signature;
import edu.spring.repositories.ISignatureRepository;

@Service
public class ServiceSignature implements IServiceSignature {
	
	@Autowired
	private ISignatureRepository dao;

	@Override
	public void save(Signature signature) {
		dao.save(signature);
	}

	@Override
	public Signature findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		dao.deleteById(id);
	}

	@Override
	public List<Signature> findAll() {
		return (List<Signature>)dao.findAll();
	}

}
