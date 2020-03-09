package edu.mum.cs.cs425.registrationmgmt.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import edu.mum.cs.cs425.registrationmgmt.annotations.Unique;
import edu.mum.cs.cs425.registrationmgmt.repository.StudentRepository;

public class UniqueValidator implements ConstraintValidator<Unique, String> {
	
	private StudentRepository studentRepository;
	
	private String message;
	
	public UniqueValidator(StudentRepository sr) {
		this.studentRepository = sr;
	}
	
	@Override
	public void initialize(Unique constraintAnnotation) {
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {		
		boolean valid = true;
		try {
			valid = value != null && studentRepository.findByStudentNumber(value);
		}catch(Exception e) {
			
		}
		if (!valid) {
			context.buildConstraintViolationWithTemplate(message)
	                .addConstraintViolation()
	                .disableDefaultConstraintViolation();
	    }
		return valid;
	}

}
