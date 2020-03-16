package edu.mum.cs.cs425.fsap.service;

import java.util.List;

import edu.mum.cs.cs425.fsap.model.Faculty;
import edu.mum.cs.cs425.fsap.model.Student;

public interface StudentService {
	public List<Student> findAll();
	public Student save(Student faculty);
	public Student findById(Long id);
	public void delete(Long id);
	//public Faculty findByFacultyId(Long id);
}
