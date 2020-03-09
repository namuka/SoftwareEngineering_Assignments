package edu.mum.cs.cs425.registrationmgmt.repository;

import java.util.List;

import edu.mum.cs.cs425.registrationmgmt.model.Student;

public interface CustomStudentRepository {
	public boolean findByStudentNumber(String value);
	public List<Student> findBySearchTerm(String value);
}
