package edu.mines.Schedule;

import java.util.ArrayList;
import java.util.Date;

import junit.framework.TestCase;

public class TeachingSessionManagerTest extends TestCase {

	public void testAddTeachingSession() throws Exception {

		CourseMeeting meeting = CourseMeetingTest.createMeeting();
		Instructor instructor = InstructorTest.createInstructor();
		TeachingSession session = new TeachingSession(instructor, meeting);

		TeachingSessionManager manager = TeachingSessionManager.getInstance();
		manager.clearData();

		// Add that session to the manager
		manager.addSession(session);

		// Now check if the list of teaching sessions contains a meeting with
		// our instructor
		ArrayList<TeachingSession> sessions = manager.getSessions();
		Instructor instructor2;
		CourseMeeting meeting2;
		for (TeachingSession s : sessions) {
			instructor2 = s.getInstructor();
			meeting2 = s.getCourseMeeting();
			// See if our instructor was in the manager's list of sessions and
			// that he was teaching the right class

			if (instructor2.getName().equals(
					InstructorTest.DEFAULT_INSTRUCTOR_NAME)
					&& instructor2.getCwid().equals(
							InstructorTest.DEFAULT_INSTRUCTOR_CWID)
					&& meeting2.toString().equals(meeting.toString())) {
				assertTrue(true);
				break;
			}
		}
	}

	public void testAddTimeConflictTeachingSession() throws Exception {
		CourseMeeting meeting = CourseMeetingTest.createMeeting();
		Instructor instructor = InstructorTest.createInstructor();
		TeachingSession session = new TeachingSession(instructor, meeting);

		TeachingSessionManager manager = TeachingSessionManager.getInstance();
		manager.clearData();
		// Add that session to the manager
		manager.addSession(session);

		// Now, create a teaching session at the same time
		long startTime2 = CourseMeetingTest.DEFAULT_MEETING_TIME.getTime() + 60;
		Classroom room = new Classroom(CourseMeetingTest.DEFAULT_CLASSROOM_ROOM, CourseMeetingTest.DEFAULT_CLASSROOM_BUILDING, CourseMeetingTest.DEFAULT_CLASSROOM_CAPACITY);
		
		CourseMeeting meeting2 = new CourseMeeting(CourseTest.createCourse(),
				room, new Date(startTime2),
				CourseMeetingTest.DEFAULT_MEETING_LENGTH);

		TeachingSession session2 = new TeachingSession(instructor, meeting2);
		try {
			manager.addSession(session2);
			// We shouldn't be able to add the session, so if we get here, the
			// test fails
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	public void testAddDepartmentConflictTeachingSession() throws Exception {
		CourseMeeting meeting = CourseMeetingTest.createMeeting();
		Instructor instructor = InstructorTest.createPhysicsInstructor();
		TeachingSession session = new TeachingSession(instructor, meeting);

		TeachingSessionManager manager = TeachingSessionManager.getInstance();
		manager.clearData();
		// Add that session to the manager
		try {
			manager.addSession(session);
			// We shouldn't be able to add the session, so if we get here, the
			// test fails
			fail();
		} catch (Exception e) {
			assertTrue(true);
		}
	}
}
