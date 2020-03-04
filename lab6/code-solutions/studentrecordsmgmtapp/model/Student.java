package edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model;
import java.time.LocalDate;

public class Student {
	private String studentId;
	private String name;
	private LocalDate dateOfAdmission;
	
	public Student() {
		
	}
	
	public Student(String stId, String n) {
		this.studentId = stId;
		this.name = n;
	}
	
	public Student(String stId, String n, LocalDate doa) {
		this.studentId = stId;
		this.name = n;
		this.dateOfAdmission = doa;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}
	
}
