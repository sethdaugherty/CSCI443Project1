package edu.mines.Schedule;

/**
 * Represents a {@link Student} instance's enrollment in a {@link CourseMeeting}
 * .
 */
public class Enrollment {
	private Student student;
	private CourseMeeting courseMeeting;

	public Enrollment(Student student, CourseMeeting courseMeeting) {
		this.student = student;
		this.courseMeeting = courseMeeting;
	}

	public Student getStudent() {
		return this.student;
	}

	public CourseMeeting getCourseMeeting() {
		return this.courseMeeting;
	}

}
