package edu.mum.cs.cs425.registrationmgmt.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs425.registrationmgmt.model.Student;

@Repository("studentRepository")
public interface StudentRepository extends JpaRepository<Student, Long>, CustomStudentRepository, JpaSpecificationExecutor<Student> {
	
}
