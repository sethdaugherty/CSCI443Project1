package edu.mines.Schedule;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TeachingSessionManagerTest extends TestCase {

	public void testAddTeachingSession() {
		
		CourseMeeting meeting = CourseMeetingTest.createMeeting();
		Instructor instructor = InstructorTest.createInstructor();
		TeachingSession session = new TeachingSession(instructor, meeting);
		
		TeachingSessionManager manager = TeachingSessionManager.getInstance();
		// Add that session to the manager
		manager.addSession(session);
		
		// Now check if the list of teaching sessions contains a meeting with our instructor
		ArrayList<TeachingSession> sessions = manager.getSessions();
		Instructor instructor2;
		CourseMeeting meeting2;
		for( TeachingSession s : sessions ) {
			instructor2 = s.getInstructor();
			meeting2 = s.getCourseMeeting();
			// See if our instructor was in the manager's list of sessions and that he was teaching the right class
			
			if(instructor2.getName().equals(InstructorTest.DEFAULT_INSTRUCTOR_NAME) && instructor2.getCwid().equals(InstructorTest.DEFAULT_INSTRUCTOR_CWID) && meeting2.toString().equals(meeting.toString())) {
				assertTrue(true);
				break;
			}
		}
	}
}
