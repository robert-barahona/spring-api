package edu.spring.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

@Table(name="Signatures")
@Entity
public class Signature {
	
	@Id
	@Column(name="id_signature")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idSignature;
	
	@NotEmpty(message = "El campo 'title' no debe estar vacío")
	@NotNull(message = "El campo 'title' no debe ser nulo")
	@Column(name="title")
	private String title;
	
	@Column(name="hours")
	private String hours;
	
	@JoinColumn(name = "fk_student", referencedColumnName = "id_student")
	@ManyToOne
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Student student;
	
	public Signature() {
		
	}

	public Long getIdSignature() {
		return idSignature;
	}

	public void setIdSignature(Long idSignature) {
		this.idSignature = idSignature;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getHours() {
		return hours;
	}

	public void setHours(String hours) {
		this.hours = hours;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
