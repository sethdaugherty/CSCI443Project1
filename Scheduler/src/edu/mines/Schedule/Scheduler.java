package edu.mines.Schedule;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class Scheduler {
	ArrayList<Student> studentList;
	ArrayList<Instructor> instructorList;
	ArrayList<CourseMeeting> courseMeetingList;
	CourseMeetingManager meetingManager;
	EnrollmentManager enrollmentManager;
	TeachingSessionManager teachingSessionManager;
	
	public Scheduler() {
		studentList = new ArrayList<Student>();
		instructorList = new ArrayList<Instructor>();
		courseMeetingList = new ArrayList<CourseMeeting>();
		
		meetingManager = CourseMeetingManager.getInstance();
		enrollmentManager = EnrollmentManager.getInstance();
		teachingSessionManager = TeachingSessionManager.getInstance();
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
	
	private void printMenu() {
		System.out.println("This interface allows you to do the following:");
		System.out.println("[1] Print this menu");
		System.out.println("[2] List Students");
		System.out.println("[3] List Instructors");
		System.out.println("[4] List Courses");
		System.out.println("[5] Add student to course");
		System.out.println("[6] Add student to course");
		System.out.println("[7] Quit");
	}
	
	
	private void addInstructor() {
		// TODO Auto-generated method stub
		
	}

	private void addStudent() {
		// TODO Auto-generated method stub
		
	}

	private void listCourses() {
		ArrayList<CourseMeeting> meetings = meetingManager.getCourseMeetingList();
		for( CourseMeeting meeting : meetings ) {
			System.out.println(meeting);
		}
	}

	private void listInstructors() {
		ArrayList<TeachingSession> sessions = teachingSessionManager.getSessions();
		HashSet<Instructor> instructors = new HashSet<Instructor>();
		for( TeachingSession session : sessions ) {
			instructors.add(session.getInstructor());
		}
		
		// We got a unique list of instructors, so lets print them
		for( Instructor instructor : instructors ) {
			System.out.println(instructor);
		}
	}

	private void listStudents() {
		ArrayList<Enrollment> enrollments = enrollmentManager.getEnrollments();
		HashSet<Student> students = new HashSet<Student>();
		for( Enrollment enrollment : enrollments ) {
			students.add(enrollment.getStudent());
		}
		
		// We got a unique list of students, so lets print them
		for( Student student : students ) {
			System.out.println(student);
		}
	}
	
	private void handleChoice(int choice) {
		switch(choice) {
			case 1:
			default:
				printMenu();
			break;
			
			case 2:
				listStudents();
			break;

			case 3:
				listInstructors();
			break;
			
			case 4:
				listCourses();
			break;
			
			case 5:
				addStudent();
			break;
			
			case 6:
				addInstructor();
			break;
			
			case 7:
				System.exit(0);
			break;
		}
	}

	public static void main(String[] args) throws IOException {
		Scheduler scheduler = new Scheduler();
		scheduler.setupStudents();
		scheduler.setupInstructors();
		scheduler.setupCourseMeetings();
		
		System.out.println("Welcome to the simple scheduling system.");
		scheduler.printMenu();
		while( true ) {
			int choice = System.in.read();
			scheduler.handleChoice(choice);
		}
		
	}

}
