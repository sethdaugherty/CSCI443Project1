package edu.mines.Schedule;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

public class EnrollmentTest extends TestCase {
	private static Student DEFAULT_ENROLLMENT_STUDENT = StudentTest
			.createStudent();
	private static CourseMeeting DEFAULT_ENROLLMENT_COURSE_MEETING = CourseMeetingTest
			.createMeeting();
	private static CourseMeeting DEFAULT_ENROLLMENT_COURSE_MEETING_2 = CourseMeetingTest
			.createMeeting2();

	/**
	 * Helper method to set up a dummy Enrollment
	 */
	public static Enrollment createEnrollment() {
		Student student = DEFAULT_ENROLLMENT_STUDENT;
		CourseMeeting courseMeeting = DEFAULT_ENROLLMENT_COURSE_MEETING;
		return new Enrollment(student, courseMeeting);
	}

	public static Enrollment createEnrollment2() {
		Student student = DEFAULT_ENROLLMENT_STUDENT;
		CourseMeeting courseMeeting = DEFAULT_ENROLLMENT_COURSE_MEETING_2;
		return new Enrollment(student, courseMeeting);
	}

	public void testCreateEnrollment() {
		Enrollment enrollment = createEnrollment();

		assertEquals("Student is incorrect", enrollment.getStudent(),
				DEFAULT_ENROLLMENT_STUDENT);
		assertEquals("CourseMeeting is incorrect", enrollment
				.getCourseMeeting(), DEFAULT_ENROLLMENT_COURSE_MEETING);
	}

}
