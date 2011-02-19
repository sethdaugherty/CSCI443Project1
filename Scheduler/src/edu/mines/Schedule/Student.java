package edu.mines.Schedule;

import java.util.ArrayList;

public class Student extends Person {
	public Student(String name, String cwid, ArrayList<Major> majors, ArrayList<Course> previousCourses) {
		super(name, cwid);
		this.majors = majors;
		this.previousCourses = previousCourses;
	}
	
	private static final double SOPHMORE_LEVEL = 30;
	private static final double JUNIOR_LEVEL = 60;
	private static final double SENIOR_LEVEL = 90;

	private ArrayList<Major> majors;
	private ArrayList<Course> previousCourses;

	public ArrayList<Major> getMajor() {
		return majors;
	}
	
	public ArrayList<Course> getCourses() {
		return previousCourses;
	}
	
	public String getStatus(){
		double sum = 0;
		for(Course course: previousCourses){
			sum = course.getNumCredits();
		}
		if(sum < SOPHMORE_LEVEL){
			return "Freshman";
		}
		else if(sum < JUNIOR_LEVEL){
			return "Sophmore";
		}
		else if(sum < SENIOR_LEVEL){
			return "Junior";
		}
		else
			return "Senior";
		}
}
	

