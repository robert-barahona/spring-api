package edu.spring.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;

@Table(name="Campus")
@Entity
public class Campus {
	
	@Id
	@Column(name="id_campus")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCampus;
	
	@NotEmpty(message = "El campo 'city' no debe estar vacío")
	@NotNull(message = "El campo 'city' no debe ser nulo")
	@Column(name="city")
	private String city;

	@Column(name="address")
	private String address;
	
	@OneToMany(mappedBy="campus", fetch=FetchType.LAZY)
	private List<Student> students;
	
	public Campus() {
		
	}

	public Long getIdCampus() {
		return idCampus;
	}

	public void setIdCampus(Long idCampus) {
		this.idCampus = idCampus;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	

}
