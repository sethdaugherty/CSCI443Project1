package edu.mines.Schedule;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

public class EnrollmentTest extends TestCase {
	private static Student DEFAULT_ENROLLMENT_STUDENT = StudentTest
			.createStudent();
	private static Student DEFAULT_ENROLLMENT_STUDENT_2 = StudentTest
			.createStudent2();
	private static CourseMeeting DEFAULT_ENROLLMENT_COURSE_MEETING = CourseMeetingTest
			.createMeeting();
	private static CourseMeeting DEFAULT_ENROLLMENT_COURSE_MEETING_WITH_PRE_REQ = CourseMeetingTest
			.createMeetingWithPreReq();

	/**
	 * Helper method to set up a dummy Enrollment
	 */
	public static Enrollment createEnrollment() {
		Student student = DEFAULT_ENROLLMENT_STUDENT;
		CourseMeeting courseMeeting = CourseMeetingTest.createMeeting();
		return new Enrollment(student, courseMeeting);
	}
	
	public static Enrollment createEnrollment2() {
		Student student = DEFAULT_ENROLLMENT_STUDENT_2;
		CourseMeeting courseMeeting = DEFAULT_ENROLLMENT_COURSE_MEETING;
		return new Enrollment(student, courseMeeting);
	}
	public static Enrollment createEnrollment3() {
		Student student = DEFAULT_ENROLLMENT_STUDENT;
		CourseMeeting courseMeeting = DEFAULT_ENROLLMENT_COURSE_MEETING;
		return new Enrollment(student, courseMeeting);
	}

	public static Enrollment createEnrollmentWithInvalidPreReq() {
		Student student = DEFAULT_ENROLLMENT_STUDENT;
		CourseMeeting courseMeeting = CourseMeetingTest.createMeetingWithPreReq();
		return new Enrollment(student, courseMeeting);
	}

	public static Enrollment createEnrollmentWithValidPreReq() {
		Student student = DEFAULT_ENROLLMENT_STUDENT_2;
		CourseMeeting courseMeeting = CourseMeetingTest.createMeetingWithPreReq();
		return new Enrollment(student, courseMeeting);
	}
	
	public static Enrollment createEnrollmentNoConflict() {
		Student student = DEFAULT_ENROLLMENT_STUDENT;
		CourseMeeting courseMeeting = CourseMeetingTest.createMeetingOther();
		return new Enrollment(student, courseMeeting);
	}

	public void testCreateEnrollment() {
		Enrollment enrollment = createEnrollment();

		assertEquals("Student is incorrect", enrollment.getStudent(),
				DEFAULT_ENROLLMENT_STUDENT);
		assertTrue("CourseMeeting is incorrect", enrollment
				.getCourseMeeting().equals(DEFAULT_ENROLLMENT_COURSE_MEETING));
	}

}
