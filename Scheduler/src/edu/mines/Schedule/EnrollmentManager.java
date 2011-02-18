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
		checkTimeConflict(enrollment);
		
		enrollments.add(enrollment);
	}

	public ArrayList<Enrollment> getEnrollments() {
		return enrollments;
	}
	
	public boolean checkTimeConflict(Enrollment enrollment) {
		return false;
	}

}
