package edu.mum.cs.cs425.fsap.service;

import java.util.List;

import edu.mum.cs.cs425.fsap.model.Faculty;
import edu.mum.cs.cs425.fsap.model.Student;

public interface FacultyService {
	public List<Faculty> findAll();
	public Faculty save(Faculty faculty);
	public Faculty findById(Long id);
	public void delete(Long id);
	//public List<Student> findByFaculty(Long id);
}
