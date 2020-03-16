package edu.mum.cs.cs425.fsap.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.fsap.model.Faculty;
import edu.mum.cs.cs425.fsap.model.Student;
import edu.mum.cs.cs425.fsap.repository.FacultyRepository;
import edu.mum.cs.cs425.fsap.service.FacultyService;

@Service
public class FacultyServiceImp implements FacultyService {

	@Autowired
	private FacultyRepository facultyRepository;
	
	public FacultyServiceImp(FacultyRepository fr) {
		this.facultyRepository = fr;
	}

	@Override
	public List<Faculty> findAll() {
		// TODO Auto-generated method stub
		return facultyRepository.findAll(Sort.by(Sort.Direction.DESC, "fullName"));
	}

	@Override
	public Faculty save(Faculty faculty) {
		// TODO Auto-generated method stub
		return facultyRepository.save(faculty);
	}

	@Override
	public Faculty findById(Long id) {
		// TODO Auto-generated method stub
		return facultyRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		facultyRepository.deleteById(id);
	}

	/*@Override
	public List<Student> findByFaculty(Long id) {
		// TODO Auto-generated method stub
		return facultyRepository.findByFaculty(id);
	}*/

	
	
}
