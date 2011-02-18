package edu.mines.Schedule;

import java.util.ArrayList;

public class TeachingSessionManager {
	private static TeachingSessionManager theInstance = null;

	private ArrayList<TeachingSession> sessions;

	private TeachingSessionManager() {
		sessions = new ArrayList<TeachingSession>();
	}

	public void addSession(TeachingSession session) throws Exception {
		if (hasTimeConflict(session)) {
			throw new Exception("The instructor has a time conflict");
		}

		sessions.add(session);
	}

	/**
	 * Make sure the instructor in the given teaching session isn't already
	 * signed up to teach a class at the same time
	 * 
	 * @param session
	 * @return
	 */
	private boolean hasTimeConflict(TeachingSession session) {
		Instructor newInstructor = session.getInstructor();
		CourseMeeting newMeeting = session.getCourseMeeting();
		// Loop through the list of sessions looking for this instructor
		for (TeachingSession s : sessions) {
			Instructor oldInstructor = s.getInstructor();
			System.out.println(oldInstructor + " " + newInstructor);
			// This is the same instructor, so lets see if the classes are at
			// the same time
			if (newInstructor.toString().equals(oldInstructor.toString())) {
				CourseMeeting oldMeeting = s.getCourseMeeting();
				if ((oldMeeting.getMeetingTime().before(
						newMeeting.getMeetingTime()) && oldMeeting.getEndTime()
						.after(newMeeting.getMeetingTime()))
						|| (newMeeting.getMeetingTime().before(
								oldMeeting.getMeetingTime()) && newMeeting
								.getEndTime()
								.after(oldMeeting.getMeetingTime()))) {
					return true;
				}
			}
		}

		return false;
	}

	public static TeachingSessionManager getInstance() {
		if (theInstance == null) {
			theInstance = new TeachingSessionManager();
		}
		return theInstance;
	}

	public ArrayList<TeachingSession> getSessions() {
		return sessions;
	}

	public void clearData() {
		sessions = new ArrayList<TeachingSession>();
	}
}
