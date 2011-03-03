package edu.mines.Schedule;

/**
 * Represents an {@link Instructor}'s designation to teach a specific
 * {@link CourseMeeting}.
 */
class TeachingSession {

	private Instructor instructor;
	private CourseMeeting courseMeeting;

	public TeachingSession(Instructor instructor, CourseMeeting meeting) {
		this.instructor = instructor;
		this.courseMeeting = meeting;

	}

	public Instructor getInstructor() {
		return instructor;
	}

	public CourseMeeting getCourseMeeting() {
		return courseMeeting;
	}

}
