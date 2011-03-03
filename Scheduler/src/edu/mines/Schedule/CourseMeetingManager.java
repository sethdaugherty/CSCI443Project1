package edu.mines.Schedule;

import java.util.ArrayList;

/**
 * Manages all {@link CourseMeeting} instances. Allows addition of
 * {@link CourseMeeting} instances and ensures that no {@link Classroom} is
 * occupied by multiple {@link CourseMeeting} instances at the same time.
 * 
 * SINGLETON.
 */
class CourseMeetingManager {
	private ArrayList<CourseMeeting> meetingList;
	private static CourseMeetingManager theInstance = null;

	private CourseMeetingManager() {
		meetingList = new ArrayList<CourseMeeting>();
	}

	static CourseMeetingManager getInstance() {
		if (theInstance == null) {
			theInstance = new CourseMeetingManager();
		}
		return theInstance;
	}

	/**
	 * Checks if the newMeeting occupies the same room at the same time as a
	 * pre-existing {@link CourseMeeting}
	 * 
	 * @param newMeeting
	 * @return true if there is a time conflict, false otherwise.
	 */
	private boolean hasTimeConflict(CourseMeeting newMeeting) {
		for (CourseMeeting oldMeeting : meetingList) {
			// First, check if the times overlap
			if (oldMeeting.overlap(newMeeting)) {
				// Next, check if the see if the classrooms are the same
				if (oldMeeting.getClassroom().equals(newMeeting.getClassroom())) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Adds a new CourseMeeting to the meetingList if there is no time conflict.
	 * 
	 * @param meeting
	 * @throws IllegalArgumentException
	 */
	void addCourseMeeting(CourseMeeting meeting) throws IllegalArgumentException {
		if (hasTimeConflict(meeting)) {
			throw new IllegalArgumentException("Course meetings have a time conflict");
		}
		meetingList.add(meeting);
	}

	void clearData() {
		meetingList = new ArrayList<CourseMeeting>();
	}

	ArrayList<CourseMeeting> getCourseMeetingList() {
		return new ArrayList<CourseMeeting>(meetingList);
	}
}
