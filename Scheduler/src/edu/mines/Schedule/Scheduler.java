package edu.mines.Schedule;

import java.util.ArrayList;

public class Scheduler {
	ArrayList<Student> studentList;
	ArrayList<Instructor> instructorList;
	ArrayList<CourseMeeting> courseMeetingList;
	
	public Scheduler() {
		studentList = new ArrayList<Student>();
		instructorList = new ArrayList<Instructor>();
		courseMeetingList = new ArrayList<CourseMeeting>();
	}


	private void setupInstructors() {
		// TODO Auto-generated method stub
		
	}

	private void setupStudents() {
		// TODO Auto-generated method stub
		
	}
	
	private void setupCourseMeetings() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		Scheduler scheduler = new Scheduler();
		scheduler.setupStudents();
		scheduler.setupInstructors();
		scheduler.setupCourseMeetings();
	}
}
