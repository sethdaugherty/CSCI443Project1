package edu.mines.Schedule;

import java.util.Set;
import java.util.HashSet;

/**
 * Manages all {@link TeachingSession} instances. Allows addition of
 * {@link TeachingSession} instances and ensures that no {@link Instructor} is
 * in multiple {@link TeachingSession} instances at the same time and no
 * {@link Instructor} is teaching a {@link Course} from a different
 * {@link Department}.
 * 
 * SINGLETON.
 */
class TeachingSessionManager {
	private static TeachingSessionManager theInstance = null;

	private Set<TeachingSession> sessions;

	private TeachingSessionManager() {
		sessions = new HashSet<TeachingSession>();
	}

	/**
	 * Adds a {@link TeachingSession} to {@link sessions} if the
	 * {@link Instructor} in the given {@link TeachingSession} is not included in
	 * another {@link TeachingSession} at the same time and that the
	 * {@link Instructor} is from the same {@link Department} as the
	 * {@link Course}.
	 * 
	 * @param session
	 * @throws IllegalArgumentException
	 */
	void addSession(TeachingSession session) throws IllegalArgumentException {
		if (!isInstructorInDepartment(session)) {
			throw new IllegalArgumentException(
					"The instructor isn't in the same department as the course");
		}

		if (hasTimeConflict(session)) {
			throw new IllegalArgumentException("The instructor has a time conflict");
		}

		sessions.add(session);
	}

	/**
	 * Make sure the {@link Instructor} in the given {@link TeachingSession} isn't
	 * already signed up to teach a {@link Course} at the same time.
	 * 
	 * @param session
	 * @return true if time conflict, false otherwise
	 */
	private boolean hasTimeConflict(TeachingSession session) {
		Instructor newInstructor = session.getInstructor();
		CourseMeeting newMeeting = session.getCourseMeeting();
		// Loop through the list of sessions looking for this instructor
		for (TeachingSession s : sessions) {
			Instructor oldInstructor = s.getInstructor();
			// This is the same instructor, so lets see if the classes are at
			// the same time
			if (newInstructor.equals(oldInstructor)) {
				CourseMeeting oldMeeting = s.getCourseMeeting();
				if (oldMeeting.overlap(newMeeting)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Checks if the {@link Instructor} and the {@link Course} in the session have
	 * the same {@link Department}.
	 * 
	 * @param session
	 * @return true if {@link Instructor} is in the same {@link Department} as the
	 *         {@link Course}, false otherwise.
	 */
	private boolean isInstructorInDepartment(TeachingSession session) {
		Instructor instructor = session.getInstructor();
		CourseMeeting meeting = session.getCourseMeeting();
		if (instructor.getDepartment().equals(meeting.getCourse().getDepartment())) {
			return true;
		} else {
			return false;
		}
	}

	static TeachingSessionManager getInstance() {
		if (theInstance == null) {
			theInstance = new TeachingSessionManager();
		}
		return theInstance;
	}

	public Set<TeachingSession> getSessions() {
		return new HashSet<TeachingSession>(sessions);
	}

	public void clearData() {
		sessions = new HashSet<TeachingSession>();
	}
}
