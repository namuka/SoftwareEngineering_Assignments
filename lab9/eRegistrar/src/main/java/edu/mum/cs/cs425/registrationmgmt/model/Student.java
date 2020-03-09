package edu.mum.cs.cs425.registrationmgmt.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.format.annotation.DateTimeFormat;

import edu.mum.cs.cs425.registrationmgmt.annotations.Unique;

@Entity
@Table(name = "students")
public class Student {
	@Id@GeneratedValue(strategy = GenerationType.AUTO)
	private Long studentId;
	
	@Column(name="student_number",unique = true, nullable = false)
	@NotEmpty(message="*Please provide student number")
	private String studentNumber;
	
	@Column(name="first_name",nullable=false)
	@NotEmpty(message="*Please provide first name")
	private String firstName;
	
	private String middleName;
	
	@Column(name="last_name", nullable=false)
	@NotEmpty(message="*Please provide last name")
	private String lastName;
	
	private Double cgpa;
	
	@Column(name="enrollment_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate enrollmentDate;
	
	@Column(name="is_international", nullable=false)
	@NotEmpty(message="*Please provide is international")
	private String isInternational;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getCgpa() {
		return cgpa;
	}

	public void setCgpa(Double cgpa) {
		this.cgpa = cgpa;
	}

	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}

	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	public String getIsInternational() {
		return isInternational;
	}

	public void setIsInternational(String isInternational) {
		this.isInternational = isInternational;
	}
	
	
	
}
