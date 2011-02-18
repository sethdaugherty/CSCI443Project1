package edu.mines.Schedule;

public class TeachingSession {
	
	public Instructor instructor;
	public CourseMeeting courseMeeting;

	public TeachingSession(Instructor instructor, CourseMeeting meeting) {
		this.instructor = instructor;
		this.courseMeeting = meeting;
		
	}
	
	public Instructor getInstructor() {
		return instructor;
	}

	public CourseMeeting getCourseMeeting() {
		return courseMeeting;
	}

}
