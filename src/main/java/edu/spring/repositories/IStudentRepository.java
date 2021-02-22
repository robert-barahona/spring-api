package edu.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.spring.model.Student;

public interface IStudentRepository extends CrudRepository<Student, Long> {
	@Query("SELECT st FROM Student st WHERE st.lastName LIKE %:lastName%")
    public List<Student> findByLastNameContains(@Param("lastName") String lastName);
}
