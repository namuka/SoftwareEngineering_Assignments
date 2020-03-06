package edu.mum.cs.cs425.studentmgmt.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Student {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@Column(name="student_number", unique=true, nullable=false)
	@NotEmpty(message = "*Please provide Student number")
	private String studentNumber;
	
	@Column(name="first_name", nullable = false)
	@NotEmpty(message = "*Please provide First name")
	private String firstName;
	
	private String middleName;
	
	@Column(name="last_name",nullable=false)
	@NotEmpty(message = "*Please provide Last name")
	private String lastName;
	
	private Double cgpa;
	private LocalDate dateOfEnrollment;
	
	@OneToOne
	@JoinColumn(name="transcript_id")
	private Transcript transcript;
	
	@ManyToMany(mappedBy="classroomStudents")
	private List<Classroom> myClasses;
	
	public Student() {
		
	}
	
	public Student(String stNumber, String fname, String mname, String lname, Double gpa, LocalDate doe) {
		this.studentNumber = stNumber;
		this.firstName = fname;
		this.middleName = mname;
		this.lastName = lname;
		this.cgpa = gpa;
		this.dateOfEnrollment = doe;
	}
	
	public void setTranscript(Transcript t) {
		this.transcript = t;
	}
	public Transcript getTranscript() {
		return this.transcript;
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
	public LocalDate getDateOfEnrollment() {
		return dateOfEnrollment;
	}
	public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
		this.dateOfEnrollment = dateOfEnrollment;
	}
	
	
}
