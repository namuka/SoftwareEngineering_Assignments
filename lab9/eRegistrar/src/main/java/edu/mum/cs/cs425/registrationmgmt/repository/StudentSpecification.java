package edu.mum.cs.cs425.registrationmgmt.repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import edu.mum.cs.cs425.registrationmgmt.model.Student;

public class StudentSpecification implements Specification<Student>{
	
	private final Student criteria;
	
	public StudentSpecification(Student cr) {
		this.criteria = cr;
	}

	public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		// TODO Auto-generated method stub
		return null;
	}

}
