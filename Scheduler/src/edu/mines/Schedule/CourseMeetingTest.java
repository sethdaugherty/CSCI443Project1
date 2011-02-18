package edu.mines.Schedule;

import java.util.Date;

import junit.framework.TestCase;

public class CourseMeetingTest extends TestCase {
	
	public static final String DEFAULT_CLASSROOM_ROOM = "testRoom";
	public static final String DEFAULT_CLASSROOM_BUILDING = "testBuilding";
	public static final int DEFAULT_CLASSROOM_CAPACITY = 30;
	// Jan 1, 2010 at 11:00 am
	public static final Date DEFAULT_MEETING_TIME = new Date(2010, 1, 1, 11, 0);
	public static final int DEFAULT_MEETING_LENGTH = 50;
	
	/**
	 * Helper method to set up a dummy CourseMeeting
	 */
	public static CourseMeeting createMeeting() {
		Course course = new Course("", "", 0.0, null);
		Classroom room = new Classroom(DEFAULT_CLASSROOM_ROOM, DEFAULT_CLASSROOM_BUILDING, DEFAULT_CLASSROOM_CAPACITY);
		CourseMeeting meeting = new CourseMeeting(course, room, DEFAULT_MEETING_TIME, DEFAULT_MEETING_LENGTH);

		return meeting;
	}
	
	/**
	 * Test that we can set up a course meeting correctly
	 * by creating a time, length, course and classroom
	 */
	public void testCreateMeeting() {		
		CourseMeeting meeting = createMeeting();
		// Lets make sure our newly created meeting has all the right parameters
		assertEquals(DEFAULT_MEETING_TIME.toString(), meeting.getMeetingTime().toString() );
		assertEquals(DEFAULT_MEETING_LENGTH, meeting.getMeetingLength());
	}

}
