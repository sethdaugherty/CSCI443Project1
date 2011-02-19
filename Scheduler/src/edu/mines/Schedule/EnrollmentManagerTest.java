package edu.mines.Schedule;

import junit.framework.TestCase;

public class EnrollmentManagerTest extends TestCase {
	public static final Student DEFAULT_ENROLLMENT_MANAGER_STUDENT = StudentTest
			.createStudent();
	public static final Enrollment DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT = EnrollmentTest
			.createEnrollment();
	public static final Enrollment DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_2 = EnrollmentTest
	.createEnrollment2();
	public static final Enrollment DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_WITH_INVALID_PREREQ = EnrollmentTest
			.createEnrollmentWithInvalidPreReq();
	public static final Enrollment DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_WITH_VALID_PREREQ = EnrollmentTest
			.createEnrollmentWithValidPreReq();
	public static final Enrollment DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_COURSE_CONFLICT = EnrollmentTest
			.createEnrollmentNoConflict();

	/**
	 * Helper method to set up a dummy EnrollmentManager
	 */
	public static EnrollmentManager createEnrollmentManager() {
		EnrollmentManager enrollmentManager = EnrollmentManager.getInstance();
		enrollmentManager.getEnrollments().clear();
		return enrollmentManager;
	}

	public void testAddEnrollment_Pass() {
		EnrollmentManager enrollmentManager = createEnrollmentManager();
		// Test it starts at size 0
		assertEquals("Size does not start at zero", enrollmentManager
				.getEnrollments().size(), 0);

		// Test it adds a course
		enrollmentManager.addEnrollment(DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT);
		assertEquals("Didn't add enrollment", enrollmentManager
				.getEnrollments().contains(
						DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT), true);
		assertEquals("Should have one enrollment", enrollmentManager
				.getEnrollments().size(), 1);

		// Test it adds a course with pre-req
		enrollmentManager
				.addEnrollment(DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_WITH_VALID_PREREQ);
		assertEquals(
				"Didn't add enrollment",
				enrollmentManager
						.getEnrollments()
						.contains(
								DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_WITH_VALID_PREREQ),
				true);
		assertEquals("Should have two enrollments", enrollmentManager
				.getEnrollments().size(), 2);

	}

	public void testAddEnrollment_FailPrereqs() {
		EnrollmentManager enrollmentManager = createEnrollmentManager();

		try {
			enrollmentManager
					.addEnrollment(DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_WITH_INVALID_PREREQ);
			fail("Should have thrown exception");
		} catch (IllegalArgumentException e) {
			// Expect this
		}
	}

	public void testAddEnrollment_FailTimeConflict() {
		EnrollmentManager enrollmentManager = createEnrollmentManager();
		enrollmentManager.addEnrollment(DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT);
		try {
			enrollmentManager
					.addEnrollment(DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT);
			fail("Should have thrown exception");
		} catch (IllegalArgumentException e) {
			// Expect this
		}
	}

	public void testAddEnrollment_FailCourseConflict() {
		EnrollmentManager enrollmentManager = createEnrollmentManager();
		enrollmentManager.addEnrollment(DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT);
		try {
			enrollmentManager
					.addEnrollment(DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_COURSE_CONFLICT);
			fail("Should not add enrollment if Student is already in the class");
		} catch (IllegalArgumentException e) {
			// Expect this
		}
	}

	public void testAddEnrollment_FailCourseFull() {
		EnrollmentManager enrollmentManager = createEnrollmentManager();
		enrollmentManager.addEnrollment(DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT);
		try {
			enrollmentManager
					.addEnrollment(DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_2);
			fail("Should not add enrollment if class is full");
		} catch (IllegalArgumentException e) {
			// Expect this
		}
	}
}
