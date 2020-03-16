package edu.mum.cs.cs425.fsap.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentId;
	
	@Column(nullable = false, unique = true)
	@NotBlank(message="*Student number can not be blank or space(s)")
	private String studentNumber;
	
	@Column(nullable = false)
	@NotBlank(message="Full name can not be blank or space(s)")
	private String fullName;
	
	@Column(nullable = true)
	private String phoneNumber;
	
	@Column(nullable = false)
	@Email(message="Please enter a valid email address")
	private String emailAddress;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(nullable = false)
	@NotNull(message="Please provide date of admission")
	private LocalDate dateOfAdmission;
	
	@Column(nullable = true)
	private Float cgpa;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="faculty_id", nullable = false)
	private Faculty faculty;
	
	public Student() {
		
	}
	
	public Student(String sn, String fn, String pn, String email, LocalDate da, Float gpa, Faculty fac) {
		this.studentNumber = sn;
		this.fullName = fn;
		this.phoneNumber = pn;
		this.emailAddress = email;
		this.dateOfAdmission = da;
		this.cgpa = gpa;
		this.faculty = fac;
	}

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

	public LocalDate getDateOfAdmission() {
		return dateOfAdmission;
	}

	public void setDateOfAdmission(LocalDate dateOfAdmission) {
		this.dateOfAdmission = dateOfAdmission;
	}

	public Float getCgpa() {
		return cgpa;
	}

	public void setCgpa(Float cgpa) {
		this.cgpa = cgpa;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentNumber=" + studentNumber + ", fullName=" + fullName
				+ ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + ", dateOfAdmission="
				+ dateOfAdmission + ", cgpa=" + cgpa + ", faculty=" + faculty + "]";
	}
	
	
}
