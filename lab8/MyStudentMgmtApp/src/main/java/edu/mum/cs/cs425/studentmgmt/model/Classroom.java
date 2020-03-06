package edu.mum.cs.cs425.studentmgmt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Classroom {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long classroomId;
	private String buildingName;
	private String roomNumber;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinTable(
		name="classroom_students",
		joinColumns=@JoinColumn(name="student_id"),
		inverseJoinColumns=@JoinColumn(name="classroom_id")
	)
	private List<Student> classroomStudents = new ArrayList<>();
	
	public Classroom() {
		
	}
	
	public Classroom(String bn, String rn) {
		this.buildingName = bn;
		this.roomNumber = rn;
	}
	
	public void addStudent(Student st) {
		this.classroomStudents.add(st);
	}
	
	public List<Student> getClassStudents(){
		return this.classroomStudents;
	}
	
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	
}
