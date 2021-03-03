package edu.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import edu.spring.model.Signature;

public interface ISignatureRepository extends CrudRepository<Signature, Long> {

}
