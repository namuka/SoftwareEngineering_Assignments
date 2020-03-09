package edu.mum.cs.cs425.registrationmgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.registrationmgmt.model.Student;
import edu.mum.cs.cs425.registrationmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.registrationmgmt.service.StudentService;

@Service("studentService")
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void delete(Long id) {
		studentRepository.deleteById(id);		
	}

	@Override
	public Student findOne(Long id) {	
		return studentRepository.findById(id).orElse(null); 
	}

	@Override
	public List<Student> search(String value) {
		// TODO Auto-generated method stub
		return studentRepository.findBySearchTerm(value);
	}

}
