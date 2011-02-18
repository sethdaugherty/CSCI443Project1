package edu.mines.Schedule;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

public class EnrollmentTest extends TestCase {
	public static Enrollment createEnrollment() {
		ArrayList<Major> majors = new ArrayList<Major>();
		majors.add(Major.CompSci);
		Student student = new Student("Bob Joe", "########", majors);
		CourseMeeting courseMeeting = CourseMeetingTest.createMeeting();
		return new Enrollment(student, courseMeeting);
	}

	public void testCreateEnrollment() {
		fail("Not yet implemented");
	}

}
