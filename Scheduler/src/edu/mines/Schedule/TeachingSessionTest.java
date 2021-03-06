package edu.mines.Schedule;

import java.util.ArrayList;
import java.util.Date;
import junit.framework.TestCase;

/**
 * Tests {@link TeachingSession} to ensure it operates correctly.
 */
public class TeachingSessionTest
		extends TestCase {

	public void testTeachingSession() {
		ArrayList<String> books = new ArrayList<String>();
		books.add("Effective Java");

		Department department = Department.CS;

		Instructor instructor = new Instructor("Noble Varughese", "123456789", department);

		Course course = CourseTest.createCourse();

		Date MEETING_TIME = new Date(2010, 1, 1, 11, 0);

		Classroom classroom = Classroom.Test;

		CourseMeeting courseMeeting = new CourseMeeting(course, classroom, MEETING_TIME, 55);

		TeachingSession teachingSession = new TeachingSession(instructor, courseMeeting);
		assertEquals("Instructor didn't match", "Noble Varughese", teachingSession.getInstructor()
				.getName());
		assertEquals("Course didn't match", course, teachingSession.getCourseMeeting().getCourse());
		assertEquals("Meeting time didn't match", MEETING_TIME, teachingSession.getCourseMeeting()
				.getMeetingTime());
		assertEquals("Wrong department", department, teachingSession.getInstructor().getDepartment());
	}

}
