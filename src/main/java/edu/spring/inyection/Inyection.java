package edu.spring.inyection;

import edu.spring.controllers.StudentController;
import edu.spring.model.Student;
import edu.spring.services.ServiceStudent;

public class Inyection {
	
	private StudentController customerBL;
	
	//Constructor
	public Inyection() {
		customerBL = new StudentController(new ServiceStudent());
	}
	
	//Setter
	public void setCustomerDataAccess() {
		customerBL.setCustomerDataAccess(new ServiceStudent());
	}
	
	public void save(Student student) {
		customerBL.save(student);
	}

}
