package edu.mum.cs.cs425.demos.studentrecordsmgmtapp;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import edu.mum.cs.cs425.demos.studentrecordsmgmtapp.model.Student;

public class MyStudentRecordsMgmtApp {
	public static void main(String[] args) {
		Student[] students = new Student[5];
		students[0] = new Student("110001", "Dave", LocalDate.of(1951,11,18));
		students[1] = new Student("110002", "Anna", LocalDate.of(1990,12,07));
		students[2] = new Student("110003", "Erica", LocalDate.of(1974,1,31));
		Student st4 = new Student("110004", "Carlos");
		st4.setDateOfAdmission( LocalDate.of(2009,8,22));
		students[3] = st4;		
		Student st5 = new Student();
		st5.setStudentId("11000");
		st5.setName("Bob");
		st5.setDateOfAdmission(LocalDate.of(1990, 3, 5));
		students[4] = st5;		
		
		System.out.println("All Students:");
		Arrays.sort(students, (o1,o2)->{
			return o1.getName().compareTo(o2.getName());
		});
		printListOfStudents(students);
		
		System.out.println("\nPlatinum Alumni Students:");
		Student[] platinumAlumni = getListOfPlatinumAlumniStudents(students);
		printListOfStudents(platinumAlumni);
	}
	
	public static void printListOfStudents(Student[] students) {	
		for(int i=0;i<students.length;i++) {
			System.out.println("Student ID: " + students[i].getStudentId() + ", Name: " + students[i].getName() + ", Date of admission: " + students[i].getDateOfAdmission());			
		}
	}
	
	public static Student[] getListOfPlatinumAlumniStudents(Student[] students) {		
		Student[] tmp = new Student[students.length];
		int index = 0;
		for(int i=1;i<students.length;i++) {
			if(LocalDate.now().compareTo(students[i].getDateOfAdmission()) >=30) {
				tmp[index] = students[i];
				index++;
			}			
		}
		Student[] result = new Student[index];
		if(tmp.length>0) {
			System.arraycopy(tmp, 0, result, 0, index);
			Arrays.sort(result, Collections.reverseOrder((o1,o2)->{
				return o1.getDateOfAdmission().compareTo(o2.getDateOfAdmission());
			}) );
		}
		return result;
	}
}
