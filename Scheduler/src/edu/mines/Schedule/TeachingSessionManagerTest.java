package edu.mines.Schedule;

import junit.framework.TestCase;

public class TeachingSessionManagerTest extends TestCase {

	public void testAddTeachingSession() {
		CourseMeeting meeting = CourseMeetingTest.createMeeting();
		Instructor instructor = new Instructor("Bob", "12345");
		TeachingSession session = new TeachingSession(instructor, meeting);
	}
}
