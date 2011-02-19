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
	 * Add an enrollment object to the Enrollment Manager Also, checks if the
	 * enrollment is valid no student has courses at the same time student must
	 * have pre-reqs for the Course student cannot already be enrolled in the
	 * Course
	 * 
	 * @param enrollment
	 */
	public void addEnrollment(Enrollment enrollment)
			throws IllegalArgumentException {
		if (!hasPreReqs(enrollment))
			throw new IllegalArgumentException(
					"Must have the required pre-reqs");

		if (hasTimeConflict(enrollment))
			throw new IllegalArgumentException(
					"Cannot have two classes at the same time");

		if (hasCourse(enrollment))
			throw new IllegalArgumentException(
					"Cannot have a student enrolled in two meetings of the same course"
							+ " at the same time");
		
		if (enrollment.getCourseMeeting().addStudent())
			enrollments.add(enrollment);
		else
			throw new IllegalArgumentException(
					"Cannot have a student enrolled in a full class");
	}

	public ArrayList<Enrollment> getEnrollments() {
		return enrollments;
	}

	/**
	 * Make sure the student in the given enrollment has the pre-reqs required
	 * for the Course in the enrollment's CourseMeeting
	 * 
	 * @param enrollment
	 * @return
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
	 * @return
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
	 * Make sure the student is not currently enrolled in the course
	 * 
	 * @param enrollment
	 * @return
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
