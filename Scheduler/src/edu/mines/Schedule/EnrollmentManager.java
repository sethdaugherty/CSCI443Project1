package edu.mines.Schedule;

import java.util.ArrayList;

public class EnrollmentManager {
	private static EnrollmentManager theInstance = null;

	private ArrayList<Enrollment> enrollments;

	private EnrollmentManager() {
		enrollments = new ArrayList<Enrollment>();
	}

	public static EnrollmentManager getInstance() {
		if (theInstance == null) {
			theInstance = new EnrollmentManager();
		}
		return theInstance;
	}

	/**
	 * Add an enrollment object to the Enrollment Manager
	 *  Also, checks if the enrollment is valid
	 *   no student has courses at the same time
	 *   student must have pre-reqs for the Course
	 * 
	 * @param enrollment
	 */
	public void addEnrollment(Enrollment enrollment) throws IllegalArgumentException {
		if (!hasPreReqs(enrollment))
			throw new IllegalArgumentException(
					"Must have the required pre-reqs");

		if (hasTimeConflict(enrollment))
			throw new IllegalArgumentException(
					"Cannot have two classes at the same time");

		enrollments.add(enrollment);
	}

	public ArrayList<Enrollment> getEnrollments() {
		return enrollments;
	}

	
	/**
	 * Make sure the student in the given enrollment has the pre-reqs
	 *  required for the Course in the enrollment's CourseMeeting
	 * 
	 * @param enrollment
	 * @return
	 */
	private boolean hasPreReqs(Enrollment enrollment) {
		ArrayList<Course> studentCourses = enrollment.getStudent().getCourses();
		for (Course c : enrollment.getCourseMeeting().getCourse().getPreReqs()) {
			if (!studentCourses.contains(c)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Make sure the student in the given enrollment doesn't have another
	 * enrollment at the same time
	 * 
	 * @param enrollment
	 * @return
	 */
	private boolean hasTimeConflict(Enrollment enrollment) {
		Student newStudent = enrollment.getStudent();
		CourseMeeting newMeeting = enrollment.getCourseMeeting();
		// Loop through the list of enrollments looking for this student
		for (Enrollment s : enrollments) {
			Student oldStudent = s.getStudent();
			// This is the same student, so lets see if the classes are at the
			// same time
			if (newStudent.toString().equals(oldStudent.toString())) {
				CourseMeeting oldMeeting = s.getCourseMeeting();
				if (newMeeting.overlap(oldMeeting)) {
					return true;
				}
			}
		}

		return false;
	}

}
