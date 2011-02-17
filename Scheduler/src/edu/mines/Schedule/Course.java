package edu.mines.Schedule;

import java.util.ArrayList;

public class Course{
	public String courseNumber;
	public String courseName;
	public double numCredits;
	public ArrayList<String> textBooks;
	
	public Course(String courseNumber, String courseName, double numCredits,
			ArrayList<String> textBooks){
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.numCredits = numCredits;
		this.textBooks = textBooks;
	}
	
	public String getCourseNumber(){
		return courseNumber;
	}
	
	public void setCourseNumber(String courseNumber){
		this.courseNumber = courseNumber;
	}
	
	public String getCourseName(){
		return courseName;
	}
	
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
	
	public double getNumCredits(){
		return numCredits;
	}
	
	public void setNumCredits(double numCredits){
		this.numCredits = numCredits;
	}
	
	public ArrayList<String> getTextBooks(){
		return textBooks;
	}
	
	public void setTextBooks(ArrayList<String> textBooks){
		this.textBooks = textBooks;
	}
	

}
