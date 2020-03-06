package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Transcript {
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transcriptId;
	private String degreeTitle;
	@OneToOne(mappedBy="transcript")
	private Student student;

	public Transcript() {
		
	}
	public Transcript(String dTitle,Student st) {
		this.degreeTitle = dTitle;
		this.student = st;
	}
	
	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

}
