package edu.mines.Schedule;

import java.util.ArrayList;

import junit.framework.TestCase;

public class InstructorTest extends TestCase {

	public static final String DEFAULT_INSTRUCTOR_NAME = "Bob Joe";
	public static final String DEFAULT_INSTRUCTOR_CWID = "12345678";
	
	/**
	 * Helper method to set up a dummy instructor
	 */
	public static Instructor createInstructor() {
		Instructor instructor = new Instructor(DEFAULT_INSTRUCTOR_NAME, DEFAULT_INSTRUCTOR_CWID);
		return instructor;
	}
	
	public void testCreateStudent() {
		Instructor instructor = createInstructor();
		
		assertEquals("Name is incorrect", instructor.getName(), DEFAULT_INSTRUCTOR_NAME);
		assertEquals("CWID is incorrect", instructor.getCwid(), DEFAULT_INSTRUCTOR_CWID);
	}

}