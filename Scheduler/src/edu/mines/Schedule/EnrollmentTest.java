package edu.mines.Schedule;

import junit.framework.TestCase;

/**
 * Tests {@link Enrollment} to ensure it operates correctly.
 */
public class EnrollmentTest extends TestCase {
	private static Student DEFAULT_ENROLLMENT_STUDENT = StudentTest.createStudent();
	private static Student DEFAULT_ENROLLMENT_STUDENT_2 = StudentTest.createStudent2();
	private static CourseMeeting DEFAULT_ENROLLMENT_COURSE_MEETING = CourseMeetingTest
			.createMeeting();

	/**
	 * Helper method to set up a dummy Enrollment
	 */
	static Enrollment createEnrollment() {
		Student student = DEFAULT_ENROLLMENT_STUDENT;
		CourseMeeting courseMeeting = CourseMeetingTest.createMeeting();
		return new Enrollment(student, courseMeeting);
	}

	static Enrollment createEnrollment2() {
		Student student = DEFAULT_ENROLLMENT_STUDENT_2;
		CourseMeeting courseMeeting = DEFAULT_ENROLLMENT_COURSE_MEETING;
		return new Enrollment(student, courseMeeting);
	}

	static Enrollment createEnrollment3() {
		Student student = DEFAULT_ENROLLMENT_STUDENT;
		CourseMeeting courseMeeting = DEFAULT_ENROLLMENT_COURSE_MEETING;
		return new Enrollment(student, courseMeeting);
	}

	static Enrollment createEnrollmentWithInvalidPreReq() {
		Student student = DEFAULT_ENROLLMENT_STUDENT;
		CourseMeeting courseMeeting = CourseMeetingTest.createMeetingWithPreReq();
		return new Enrollment(student, courseMeeting);
	}

	static Enrollment createEnrollmentWithValidPreReq() {
		Student student = DEFAULT_ENROLLMENT_STUDENT_2;
		CourseMeeting courseMeeting = CourseMeetingTest.createMeetingWithPreReq();
		return new Enrollment(student, courseMeeting);
	}

	static Enrollment createEnrollmentNoConflict() {
		Student student = DEFAULT_ENROLLMENT_STUDENT;
		CourseMeeting courseMeeting = CourseMeetingTest.createMeetingOther();
		return new Enrollment(student, courseMeeting);
	}

	public void testCreateEnrollment() {
		Enrollment enrollment = createEnrollment();

		assertEquals("Student is incorrect", enrollment.getStudent(), DEFAULT_ENROLLMENT_STUDENT);
		assertTrue("CourseMeeting is incorrect", enrollment.getCourseMeeting().equals(
				DEFAULT_ENROLLMENT_COURSE_MEETING));
	}

}
