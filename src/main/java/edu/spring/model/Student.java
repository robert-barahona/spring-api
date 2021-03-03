package edu.spring.model;

import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name="Students")
@Entity
public class Student {
	
	@Id
	@Column(name="id_student")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idStudent;
	
	@NotEmpty(message = "El 'firstName' no debe estar vacío")
	@NotNull(message = "El 'firstName' no debe ser nulo")
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@JoinColumn(name = "fk_campus", referencedColumnName = "id_campus")
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Campus campus;
	
	@OneToMany(mappedBy="student", fetch=FetchType.LAZY)
	private List<Signature> signature;
	
	public Student() {
		
	}
	
	public Student(Long idStudent) {
		this.idStudent = idStudent;
	}

	public Long getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(Long idStudent) {
		this.idStudent = idStudent;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Campus getCampus() {
		return campus;
	}

	public void setCampus(Campus campus) {
		this.campus = campus;
	}

	public List<Signature> getSignature() {
		return signature;
	}

	public void setSignature(List<Signature> signature) {
		this.signature = signature;
	}
	
	
}
