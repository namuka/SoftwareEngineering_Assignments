package edu.mum.cs.cs425.registrationmgmt.service;

import java.util.List;

import edu.mum.cs.cs425.registrationmgmt.model.Student;

public interface StudentService {
	 List<Student> findAll();
	 Student save(Student student);
	 Student findOne(Long id);
	 void delete(Long id);
	 List<Student> search(String value);
}
