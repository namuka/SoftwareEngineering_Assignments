package edu.mum.cs.cs425.registrationmgmt.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import edu.mum.cs.cs425.registrationmgmt.validators.UniqueValidator;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueValidator.class)
public @interface Unique {
	String message() default "{edu.mum.cs.cs425.registrationmgmt.annotations.Unique.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
