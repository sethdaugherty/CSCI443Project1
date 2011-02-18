package edu.mines.Schedule;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

public class EnrollmentTest extends TestCase {
	
	/**
	 * Helper method to set up a dummy Enrollment
	 */
	public static Enrollment createEnrollment() {
		Student student = StudentTest.createStudent();
		CourseMeeting courseMeeting = CourseMeetingTest.createMeeting();
		return new Enrollment(student, courseMeeting);
	}

	public void testCreateEnrollment() {
		fail("Not yet implemented");
	}

}
