package edu.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.spring.model.Campus;

public interface ICampusRepository extends CrudRepository<Campus, Long> {
	
}
