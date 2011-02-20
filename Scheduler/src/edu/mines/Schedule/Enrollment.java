package edu.mines.Schedule;

/**
 * Represents a {@link Student} instance's enrollment in a {@link CourseMeeting}.
 */
class Enrollment {
	private Student student;
	private CourseMeeting courseMeeting;
	
	Enrollment(Student student, CourseMeeting courseMeeting) {
		this.student = student;
		this.courseMeeting = courseMeeting;
	}
	
	Student getStudent() {
		return this.student;
	}
	
	CourseMeeting getCourseMeeting() {
		return this.courseMeeting;
	}

}
