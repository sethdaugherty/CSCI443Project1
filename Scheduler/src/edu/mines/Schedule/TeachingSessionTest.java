package edu.mines.Schedule;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Date;

public class TeachingSessionTest extends TestCase {

	public void testTeachingSession() {
		ArrayList<String> books = new ArrayList<String>();
		books.add("Effective Java");
		
		Department department = new Department("Computer Science", "CSCI");
		
		Instructor instructor = new Instructor("Noble Varughese", "123456789", department);
		
		Course course = new Course("CSCI 443", "Advanced Java", 3.0, books) ;
		
		Date MEETING_TIME = new Date(2010, 1, 1, 11, 0);
		
		Classroom classroom = new Classroom("B60", "CTLM", 30);
		
		CourseMeeting courseMeeting = new CourseMeeting(course, classroom, MEETING_TIME, 55);
		
		
		
		TeachingSession teachingSession = new TeachingSession(instructor, courseMeeting);
		assertEquals("Instructor didn't match", "Noble Varughese",
				teachingSession.instructor.getName());
		assertEquals("Course didn't match", course,
				teachingSession.courseMeeting.getCourse());
		assertEquals("Meeting time didn't match", MEETING_TIME,
				teachingSession.courseMeeting.getMeetingTime());
		assertEquals("Wrong department", department,
				teachingSession.instructor.getDepartment());
	}

}
