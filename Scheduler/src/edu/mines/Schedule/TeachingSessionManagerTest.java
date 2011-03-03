package edu.mines.Schedule;

import java.util.Date;
import java.util.Set;

import junit.framework.TestCase;

/**
 * Tests {@link TeachingSessionManager} to ensure it operates correctly.
 */
public class TeachingSessionManagerTest
		extends TestCase {

	public void testAddTeachingSession() throws Exception {

		CourseMeeting meeting = CourseMeetingTest.createMeeting();
		Instructor instructor = InstructorTest.createInstructor();
		TeachingSession session = new TeachingSession(instructor, meeting);

		CourseMeeting meeting2 = CourseMeetingTest.createPhysicsMeeting();
		Instructor instructor2 = InstructorTest.createPhysicsInstructor();
		TeachingSession session2 = new TeachingSession(instructor2, meeting2);

		TeachingSessionManager manager = TeachingSessionManager.getInstance();
		manager.clearData();

		// Add that session to the manager
		manager.addSession(session);
		manager.addSession(session2);

		// Now check if the list of teaching sessions contains a meeting with
		// our instructor
		Set<TeachingSession> sessions = manager.getSessions();
		Instructor instructor3;
		CourseMeeting meeting3;
		for (TeachingSession s : sessions) {
			instructor3 = s.getInstructor();
			meeting3 = s.getCourseMeeting();
			// See if our instructor was in the manager's list of sessions and
			// that he was teaching the right class

			if (instructor3.getName().equals(InstructorTest.DEFAULT_INSTRUCTOR_NAME)
					&& instructor3.getCwid().equals(InstructorTest.DEFAULT_INSTRUCTOR_CWID)
					&& meeting3.toString().equals(meeting.toString())) {
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
		Classroom room = Classroom.Test;

		CourseMeeting meeting2 = new CourseMeeting(CourseTest.createCourse(), room,
				new Date(startTime2), CourseMeetingTest.DEFAULT_MEETING_LENGTH);

		TeachingSession session2 = new TeachingSession(instructor, meeting2);
		try {
			manager.addSession(session2);
			// We shouldn't be able to add the session, so if we get here, the
			// test fails
			fail();
		} catch (IllegalArgumentException e) {
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
		} catch (IllegalArgumentException e) {
			assertTrue(true);
		}
	}
}
