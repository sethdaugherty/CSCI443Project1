package edu.mines.Schedule;

import java.util.ArrayList;

public class Course{
	private String courseNumber;
	private String courseName;
	private double numCredits;
	private ArrayList<String> textBooks;
	private ArrayList<Course> preReqs;
	private Department department;
	
	public Course(String courseNumber, String courseName, Department department, double numCredits,
			ArrayList<String> textBooks, ArrayList<Course> preReqs){
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.numCredits = numCredits;
		this.textBooks = textBooks;
		this.preReqs = preReqs;
	}
	
	public String getCourseNumber(){
		return courseNumber;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public Department getDepartment(){
		return department;
	}
	
	public double getNumCredits(){
		return numCredits;
	}
		
	public ArrayList<String> getTextBooks(){
		return textBooks;
	}
	
	public ArrayList<Course> getPreReqs() {
		return preReqs;
	}
	
}
