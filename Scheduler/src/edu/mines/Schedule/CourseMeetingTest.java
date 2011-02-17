package edu.mines.Schedule;

import java.util.Date;

import junit.framework.TestCase;

public class CourseMeetingTest extends TestCase {
	
	/**
	 * Test that we can set up a course meeting correctly
	 * by creating a time, length, course and classroom
	 */
	public void testCreateMeeting() {
		Course course = new Course();
		Classroom room = new Classroom();
		Date time = new Date();
		int length = 50; // In minutes
		
		CourseMeeting meeting = new CourseMeeting(course, room, time, length);
		// Lets make sure our newly created meeting has all the right parameters
		assertEquals(time.toString(), meeting.getMeetingTime().toString() );
		assertEquals(length, meeting.getMeetingLength());
	}
	
}
