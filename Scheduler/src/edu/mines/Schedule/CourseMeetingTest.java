package edu.mines.Schedule;

import java.util.Date;
import junit.framework.TestCase;

/**
 * Tests {@link Course} to ensure it operates correctly
 */
public class CourseMeetingTest extends TestCase {

	public static final int DEFAULT_MEETING_DATE_NUMBER = 1262343600;
	static final int DEFAULT_MEETING_LENGTH = 50;
	static final int DEFAULT_MEETING_LENGTH_2 = 2 * DEFAULT_MEETING_LENGTH;
	// Jan 1, 2010 at 11:00 am
	static final Date DEFAULT_MEETING_TIME = new Date(DEFAULT_MEETING_DATE_NUMBER);
	static final Date DEFAULT_MEETING_TIME_EARLY = new Date(DEFAULT_MEETING_DATE_NUMBER
			- CourseMeeting.getMilliSeconds(DEFAULT_MEETING_LENGTH / 2));
	static final Date DEFAULT_MEETING_TIME_LATER = new Date(DEFAULT_MEETING_DATE_NUMBER
			+ CourseMeeting.getMilliSeconds(DEFAULT_MEETING_LENGTH / 2));
	static final Date DEFAULT_MEETING_TIME_OTHER = new Date(DEFAULT_MEETING_DATE_NUMBER
			- CourseMeeting.getMilliSeconds(DEFAULT_MEETING_LENGTH * 2));

	/**
	 * Helper method to set up a dummy CourseMeeting
	 */
	public static CourseMeeting createMeeting() {
		Course course = CourseTest.createCourse();
		Classroom room = Classroom.Test;
		CourseMeeting meeting = new CourseMeeting(course, room, DEFAULT_MEETING_TIME,
				DEFAULT_MEETING_LENGTH);

		return meeting;
	}

	public static CourseMeeting createMeetingWithPreReq() {
		Course course = CourseTest.createCourseWithPreReq();
		Classroom room = Classroom.Test;
		CourseMeeting meeting = new CourseMeeting(course, room, DEFAULT_MEETING_TIME,
				DEFAULT_MEETING_LENGTH);

		return meeting;
	}

	public static CourseMeeting createMeetingEarly() {
		Course course = CourseTest.createCourse();
		Classroom room = Classroom.Test;
		CourseMeeting meeting = new CourseMeeting(course, room, DEFAULT_MEETING_TIME_EARLY,
				DEFAULT_MEETING_LENGTH);

		return meeting;
	}

	public static CourseMeeting createMeetingLater() {
		Course course = CourseTest.createCourse();
		Classroom room = Classroom.Test;
		CourseMeeting meeting = new CourseMeeting(course, room, DEFAULT_MEETING_TIME_LATER,
				DEFAULT_MEETING_LENGTH);

		return meeting;
	}

	public static CourseMeeting createMeetingLong() {
		Course course = CourseTest.createCourse();
		Classroom room = Classroom.Test;
		CourseMeeting meeting = new CourseMeeting(course, room, DEFAULT_MEETING_TIME_EARLY,
				DEFAULT_MEETING_LENGTH_2);

		return meeting;
	}

	public static CourseMeeting createMeetingOther() {
		Course course = CourseTest.createCourse();
		Classroom room = Classroom.CTLM102;
		CourseMeeting meeting = new CourseMeeting(course, room, DEFAULT_MEETING_TIME_OTHER,
				DEFAULT_MEETING_LENGTH_2);

		return meeting;
	}

	public static CourseMeeting createPhysicsMeeting() {
		Course course = CourseTest.createPhysicsCourse();
		Classroom room = Classroom.Test;
		CourseMeeting meeting = new CourseMeeting(course, room, DEFAULT_MEETING_TIME,
				DEFAULT_MEETING_LENGTH);

		return meeting;
	}

	/**
	 * Test that we can set up a course meeting correctly by creating a time,
	 * length, course and classroom
	 */
	public void testCreateMeeting() {
		CourseMeeting meeting = createMeeting();
		// Lets make sure our newly created meeting has all the right parameters
		assertEquals(DEFAULT_MEETING_TIME.toString(), meeting.getMeetingTime().toString());
		assertEquals(DEFAULT_MEETING_LENGTH, meeting.getMeetingLength());
	}

	/**
	 * Test that overlap function correctly detects overlapping course times
	 */
	public void testOverlap() {
		CourseMeeting earlyMeeting = createMeetingEarly();
		CourseMeeting lateMeeting = createMeetingLater();
		CourseMeeting normMeeting = createMeeting();
		CourseMeeting longMeeting = createMeetingLong();
		CourseMeeting otherMeeting = createMeetingOther();

		assertEquals("Should overlap", earlyMeeting.overlap(normMeeting), true);
		assertEquals("Should overlap", lateMeeting.overlap(normMeeting), true);
		assertEquals("Should overlap", longMeeting.overlap(normMeeting), true);
		assertEquals("Should overlap", normMeeting.overlap(normMeeting), true);
		assertEquals("Should not overlap", otherMeeting.overlap(normMeeting), false);
	}
	
	/**
	 * Test same classroom
	 */
	public void testSameClassroom() {
    CourseMeeting normMeeting = createMeeting();
    CourseMeeting otherMeeting = createMeetingOther();

    assertEquals("Should have same classroom", normMeeting.sameClassroomAs(normMeeting), true);
    assertEquals("Should not have same classroom", otherMeeting.overlap(normMeeting), false);
  }

}
