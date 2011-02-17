package edu.mines.Schedule;

import java.util.ArrayList;

public class Student extends Person {
	public Student(String name, String cwid, ArrayList<Majors> majors) {
		super(name, cwid);
		this.majors = majors;
	}

	private ArrayList<Majors> majors;

	public ArrayList<Majors> getMajor() {
		return majors;
	}

	public void setMajor(ArrayList<Majors> majors) {
		this.majors = majors;
	}
	
}
