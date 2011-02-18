package edu.mines.Schedule;

import java.util.ArrayList;

public class EnrollmentManager {
	private static EnrollmentManager theInstance = null;
	
	private ArrayList<Enrollment> enrollments;
	
	private EnrollmentManager() {
		enrollments = new ArrayList<Enrollment>();
	}

	public static EnrollmentManager getInstance() {
		if(theInstance == null ) {
			theInstance = new EnrollmentManager();
		}
		return theInstance;
	}
	
	public void addEnrollment(Enrollment enrollment) {
		if (!checkPreReqs(enrollment))
			throw new IllegalArgumentException("Must have the required pre-reqs");
		
		if (!checkTimeConflict(enrollment))
			throw new IllegalArgumentException("Cannot have two classes at the same time");
		
		enrollments.add(enrollment);
	}

	public ArrayList<Enrollment> getEnrollments() {
		return enrollments;
	}
	
	public boolean checkPreReqs(Enrollment enrollment) {
		ArrayList<Course> studentCourses = enrollment.getStudent().getCourses();
		for(Course c : enrollment.getCourseMeeting().getCourse().getPreReqs()) {
			if (!studentCourses.contains(c)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkTimeConflict(Enrollment enrollment) {
		return true;
	}

}
