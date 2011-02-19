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
		ArrayList<Major> major = new ArrayList<Major>();
		major.add(Major.CompSci);
		Student student1 = new Student("Hugh Mann", "44886266", major, null);
		Student student2 = new Student("Justin Case", "54863295", major, null);
		Student student3 = new Student("Jim Marcus", "77775554", major, null);
		Student student4 = new Student("Rico Salvo", "87895641", major, null);
		Student student5 = new Student("Marco System", "13467985", major, null);
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		studentList.add(student4);
		studentList.add(student5);
				
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
