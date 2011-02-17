package edu.mines.Schedule;

import java.util.ArrayList;

public class Student extends Person {
	public Student(String name, String cwid, ArrayList<Major> majors) {
		super(name, cwid);
		this.majors = majors;
	}

	private ArrayList<Major> majors;

	public ArrayList<Major> getMajor() {
		return majors;
	}

	public void setMajor(ArrayList<Major> majors) {
		this.majors = majors;
	}
	
}
