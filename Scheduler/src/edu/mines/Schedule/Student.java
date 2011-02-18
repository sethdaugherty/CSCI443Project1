package edu.mines.Schedule;

import java.util.ArrayList;

public class Student extends Person {
	public Student(String name, String cwid, ArrayList<Major> majors, ArrayList<Course> previousCourses) {
		super(name, cwid);
		this.majors = majors;
		this.previousCourses = previousCourses;
	}

	private ArrayList<Major> majors;
	private ArrayList<Course> previousCourses;

	public ArrayList<Major> getMajor() {
		return majors;
	}

	public void setMajor(ArrayList<Major> majors) {
		this.majors = majors;
	}
	
	public ArrayList<Course> getCourses() {
		return previousCourses;
	}
	
}
