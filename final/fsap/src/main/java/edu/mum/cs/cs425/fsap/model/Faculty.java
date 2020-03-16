package edu.mum.cs.cs425.fsap.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Faculty {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long facultyId;
	
	@Column(nullable = false)
	@NotBlank(message="Full name can not be blank or space(s)")
	private String fullName;
	
	@Column(nullable = true)
	private String phoneNumber;
	
	@Column(nullable = false)
	@Email(message="Please provide a valid email address")
	@NotBlank(message="Email address can not be blank or space(s)")
	private String emailAddress;
	
	@Column(nullable = true)
	private String officeLocation;
	
	@OneToMany(mappedBy = "faculty", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Student> students = new ArrayList<>();
	
	public Faculty() {
		
	}
	public Faculty(String fn, String pn, String email, String ol) {
		this.fullName = fn;
		this.phoneNumber = pn;
		this.emailAddress = email;
		this.officeLocation = ol;
		
		
	}
	
	public void addStudent(Student student) {
		this.students.add(student);
	}
	
	public List<Student> getStudents(){
		return this.students;
	}
	public Long getFacultyId() {
		return facultyId;
	}
	public void setFacultyId(Long facultyId) {
		this.facultyId = facultyId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getOfficeLocation() {
		return officeLocation;
	}
	public void setOfficeLocation(String officeLocation) {
		this.officeLocation = officeLocation;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	@Override
	public String toString() {
		return "Faculty [facultyId=" + facultyId + ", fullName=" + fullName + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + ", officeLocation=" + officeLocation + ", students=" + students
				+ "]";
	}
	
	
}
