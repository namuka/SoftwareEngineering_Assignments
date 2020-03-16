package edu.mum.cs.cs425.fsap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.fsap.model.Faculty;
import edu.mum.cs.cs425.fsap.model.Student;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long>{
	 //List<Student> findByFaculty(Long id);
}
