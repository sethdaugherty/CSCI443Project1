package edu.mines.Schedule;

import java.util.ArrayList;

public class CourseMeetingManager {
	ArrayList<CourseMeeting> meetingList;
	private static CourseMeetingManager theInstance = null;

	private CourseMeetingManager() {
		meetingList = new ArrayList<CourseMeeting>();
	}
	
	public static CourseMeetingManager getInstance() {
		if (theInstance == null) {
			theInstance = new CourseMeetingManager();
		}
		return theInstance;
	}
	
	/**
	 * 
	 * @param session
	 * @return
	 */
	private boolean hasTimeConflict( CourseMeeting newMeeting ) {
		for (CourseMeeting oldMeeting : meetingList) {
			// First, check if the times overlap
			if( oldMeeting.overlap(newMeeting) ) {
				// Next, check if the see if the classrooms are the same
				if( oldMeeting.getClassroom().equals(newMeeting.getClassroom()) ) {
					return true;
				}
			}
		}

		return false;
	}
	
	public void addCourseMeeting( CourseMeeting meeting ) throws Exception {
		if (hasTimeConflict(meeting)) {
			throw new Exception("Course meetings have a time conflict");
		}
		meetingList.add(meeting);
	}
	

	public void clearData() {
		meetingList = new ArrayList<CourseMeeting>();
	}

	public ArrayList<CourseMeeting> getCourseMeetingList() {
		return new ArrayList<CourseMeeting>(meetingList);
	}
}
