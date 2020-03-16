package edu.mum.cs.cs425.fsap.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.fsap.model.Faculty;
import edu.mum.cs.cs425.fsap.model.Student;
import edu.mum.cs.cs425.fsap.repository.FacultyRepository;
import edu.mum.cs.cs425.fsap.repository.StudentRepository;
import edu.mum.cs.cs425.fsap.service.StudentService;

@Service
public class StudentServiceImp implements StudentService{
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	public StudentServiceImp(StudentRepository sr) {
		this.studentRepository = sr;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll(Sort.by(Sort.Direction.ASC, "fullName"));
	}

	@Override
	public Student save(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
		
	}

	@Override
	public Student findById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		studentRepository.deleteById(id);
	}

	/*@Override
	public Faculty findByFacultyId(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.findByFacultyId(id);
	}*/

}
