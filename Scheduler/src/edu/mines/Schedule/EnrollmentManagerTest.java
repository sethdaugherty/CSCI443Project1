package edu.mines.Schedule;

import junit.framework.TestCase;

public class EnrollmentManagerTest extends TestCase {
	public static final Student DEFAULT_ENROLLMENT_MANAGER_STUDENT = StudentTest
			.createStudent();
	public static final Enrollment DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_1 = EnrollmentTest
			.createEnrollment();
	public static final Enrollment DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_2 = EnrollmentTest
			.createEnrollment();
	public static final Enrollment DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_3 = EnrollmentTest
			.createEnrollment();

	/**
	 * Helper method to set up a dummy EnrollmentManager
	 */
	public static EnrollmentManager createEnrollmentManager() {
		EnrollmentManager enrollmentManager = EnrollmentManager.getInstance();

		return enrollmentManager;
	}

	public void testAddEnrollment_FailPrereqs() {
		fail("Not yet implemented");
	}

	public void testAddEnrollment_FailTimeConflict() {
		fail("Not yet implemented");
	}

	public void testAddEnrollment_Pass() {
		EnrollmentManager enrollmentManager = createEnrollmentManager();

		assertEquals("Size does not start at zero", enrollmentManager
				.getEnrollments().size(), 0);
		enrollmentManager
				.addEnrollment(DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_1);
		assertEquals("Didn't add enrollment", enrollmentManager
				.getEnrollments().contains(
						DEFAULT_ENROLLMENT_MANAGER_ENROLLMENT_1), true);
		assertEquals("Should have one enrollment", enrollmentManager
				.getEnrollments().size(), 1);
	}

}
