package edu.mines.Schedule;

import java.util.ArrayList;

/**
 * Manages all {@link Enrollment} instances. Allows addition of
 * {@link Enrollment} instances and ensures that each {@link Enrollment}
 * instance is valid. A instance is valid if the contained {@link Student} has
 * no {@link CourseMeeting}s that overlap with the {@link Enrollment} instance's
 * {@link CourseMeeting}, has all required Pre-Req {@link Course}s for the
 * {@link Enrollment} instance's {@link CourseMeeting}, is not already involved
 * in an {@link Enrollment} for a different {@link CourseMeeting} of the same
 * {@link Course}, and the {@link Enrollment} instance's {@link CourseMeeting}
 * does not have full capacity.
 * 
 * SINGLETON.
 */
class EnrollmentManager {
	private static EnrollmentManager theInstance = null;

	private ArrayList<Enrollment> enrollments;

	private EnrollmentManager() {
		enrollments = new ArrayList<Enrollment>();
	}

	static EnrollmentManager getInstance() {
		if (theInstance == null) {
			theInstance = new EnrollmentManager();
		}
		return theInstance;
	}

	/**
	 * Add an enrollment object to the Enrollment Manager Also, checks if the
	 * enrollment is valid no student has courses at the same time student must
	 * have pre-reqs for the Course student cannot already be enrolled in the
	 * Course.
	 * 
	 * @param enrollment
	 * @throws IllegalArgumentException
	 */
	void addEnrollment(Enrollment enrollment)
			throws IllegalArgumentException {
		// Check for pre-reqs
		if (!hasPreReqs(enrollment)) 
			throw new IllegalArgumentException(
					"Must have the required pre-reqs");
		
		// Check for Time Conflict
		if (hasTimeConflict(enrollment)) 
			throw new IllegalArgumentException(
					"Cannot have two classes at the same time");

		// Check if already enrolled in provided Course
		if (hasCourse(enrollment)) 
			throw new IllegalArgumentException(
					"Cannot have a student enrolled in two meetings of the same course"
							+ " at the same time");
		
		// Check if room in the CourseMeeting
		if (enrollment.getCourseMeeting().addStudent()) 
			enrollments.add(enrollment);
		else
			throw new IllegalArgumentException(
					"Cannot have a student enrolled in a full class");
	}

	ArrayList<Enrollment> getEnrollments() {
		return enrollments;
	}

	/**
	 * Make sure the {@link Student} in {@link enrollment} has the pre-reqs required
	 * for the {@link Course} in the {@link enrollment}'s {@link CourseMeeting}.
	 * 
	 * @param enrollment
	 * @return true if the {@link Student} has the pre-reqs, false otehrwise.
	 */
	private boolean hasPreReqs(Enrollment enrollment) {
		ArrayList<Course> studentCourses = enrollment.getStudent().getCourses();
		return studentCourses.containsAll(enrollment.getCourseMeeting()
				.getCourse().getPreReqs());
	}

	/**
	 * Make sure the student in the given enrollment doesn't have another
	 * enrollment at the same time
	 * 
	 * @param enrollment
	 * @return true if there is a time conflict, false otherwise.
	 */
	private boolean hasTimeConflict(Enrollment enrollment) {
		Student newStudent = enrollment.getStudent();
		CourseMeeting newMeeting = enrollment.getCourseMeeting();
		// Loop through the list of enrollments looking for this student
		for (Enrollment e : enrollments) {
			Student oldStudent = e.getStudent();
			// This is the same student, so lets see if the classes are at the
			// same time
			if (newStudent.equals(oldStudent)) {
				CourseMeeting oldMeeting = e.getCourseMeeting();
				if (newMeeting.overlap(oldMeeting)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Make sure the {@link Student} in {@link enrollment} is not currently
	 * enrolled in the same (@link Course} as in another of the {@link Student}
	 * 's {@link Enrollment}s.
	 * 
	 * @param enrollment
	 * @return true if the Student is already enrolled in the course, false otherwise.
	 */
	private boolean hasCourse(Enrollment enrollment) {
		Student newStudent = enrollment.getStudent();
		Course newCourse = enrollment.getCourseMeeting().getCourse();

		for (Enrollment e : enrollments) {
			Student oldStudent = e.getStudent();
			Course oldCourse = e.getCourseMeeting().getCourse();
			if (oldStudent.equals(newStudent) && oldCourse.equals(newCourse)) {
				return true;
			}
		}
		return false;
	}

}
