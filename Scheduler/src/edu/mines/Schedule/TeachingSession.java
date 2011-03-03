package edu.mines.Schedule;

/**
 * Represents an {@link Instructor}'s designation to teach a specific
 * {@link CourseMeeting}.
 */
class TeachingSession {

	private Instructor instructor;
	private CourseMeeting courseMeeting;

	TeachingSession(Instructor instructor, CourseMeeting meeting) {
		this.instructor = instructor;
		this.courseMeeting = meeting;

	}

	Instructor getInstructor() {
		return instructor;
	}

	CourseMeeting getCourseMeeting() {
		return courseMeeting;
	}

}
