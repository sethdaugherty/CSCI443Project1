package edu.mines.Schedule;

import java.util.ArrayList;

import junit.framework.TestCase;

public class CourseMeetingManagerTest extends TestCase {

	public void testAddCourseMeeting() throws Exception {
		CourseMeeting meeting = CourseMeetingTest.createMeeting();
		CourseMeeting meeting2 = CourseMeetingTest.createMeeting2();
		
		CourseMeetingManager manager = CourseMeetingManager.getInstance();
		manager.clearData();
		
		manager.addCourseMeeting(meeting);
		manager.addCourseMeeting(meeting2);
		
		// Lets make sure the course meeting is now in the manager's list
		ArrayList<CourseMeeting> meetings = manager.getCourseMeetingList();
		boolean found = false;
		for( CourseMeeting courseMeeting: meetings ) {
			if ( courseMeeting.equals(meeting) ) {
				found = true;
			}
		}
		
		if ( !found ) {
			fail("CourseMeeting wasn't in the list");
		}
	}
	
	public void testAddConflictCourseMeeting() {
		CourseMeeting meeting = CourseMeetingTest.createMeeting();
		
		CourseMeetingManager manager = CourseMeetingManager.getInstance();
		manager.clearData();
		
		try {
			manager.addCourseMeeting(meeting);
			manager.addCourseMeeting(meeting);
			// If we get here, the check conflict code didn't work
			fail("Didn't detect time conflict");
		}
		catch (Exception e ) {
			assertTrue(true);
		}
		
		// Lets make sure the course meeting is now in the manager's list
		ArrayList<CourseMeeting> meetings = manager.getCourseMeetingList();
		boolean found = false;
		for( CourseMeeting courseMeeting: meetings ) {
			if ( courseMeeting.equals(meeting) ) {
				found = true;
			}
		}
		
		if ( !found ) {
			fail("CourseMeeting wasn't in the list");
		}
	}
}
