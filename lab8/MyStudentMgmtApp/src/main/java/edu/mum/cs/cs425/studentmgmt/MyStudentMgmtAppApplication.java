package edu.mum.cs.cs425.studentmgmt;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.studentmgmt.model.Classroom;
import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.model.Transcript;
import edu.mum.cs.cs425.studentmgmt.repository.IClassroomRepository;
import edu.mum.cs.cs425.studentmgmt.repository.IStudentRepository;
import edu.mum.cs.cs425.studentmgmt.repository.ITranscriptRepository;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner{
	
	@Autowired
	private IStudentRepository studentRepository;
	@Autowired 
	private ITranscriptRepository transcriptRepository;
	@Autowired
	private IClassroomRepository classroomRepository;

	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Welcome to StudentsMgmtApp version 1.0");
				
		Student st = new Student("000-61-0001", "Anna","Lynn","Smith",3.45,LocalDate.of(2019, 5, 24));		
		saveStudent(st);		
		getListOfStudents().forEach(System.out::println);		
		
		
	}
	private void saveStudent(Student st) {
		Student savedSt = studentRepository.save(st);
		//System.out.println(savedSt);
		
		//Create Transcript and connect to Student
		Transcript t = new Transcript("BS Computer Science", st);
		Transcript savedTranscript = transcriptRepository.save(t);
		savedSt.setTranscript(savedTranscript);
		studentRepository.save(savedSt);
		System.out.println("Transcript: ");
		System.out.println(savedTranscript);
		
		//Create Classroom and add a student
		Classroom cr = new Classroom("McLaughlin building", "M105");
		cr.addStudent(savedSt);
		Classroom savedClassroom = classroomRepository.save(cr);
		System.out.println("Classroom: ");
		System.out.println(savedClassroom);
	}
	
	private Iterable<Student> getListOfStudents(){
		return studentRepository.findAll();
	}

}
