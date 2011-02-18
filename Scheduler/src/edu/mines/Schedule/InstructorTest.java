package edu.mines.Schedule;

import java.util.ArrayList;

import junit.framework.TestCase;

public class InstructorTest extends TestCase {

	public static final String DEFAULT_INSTRUCTOR_NAME = "Bob Joe";
	public static final String DEFAULT_INSTRUCTOR_CWID = "12345678";
	public static final Department DEFAULT_INSTRUCTOR_DEPARTMENT = new Department("Computer Science", "CSCI");
	public static final Major DEFAULT_INSTRUCTOR_MAJOR = Major.CompSci;
	
	public static final String DEFAULT_PHYSICS_INSTRUCTOR_NAME = "Chuck Stone";
	public static final String DEFAULT_PHYSICS_INSTRUCTOR_CWID = "87654321";
	public static final Department DEFAULT_PHYSICS_INSTRUCTOR_DEPARTMENT = new Department("Physics", "PHGN");
	public static final Major DEFAULT_PHYSICS_INSTRUCTOR_MAJOR = Major.Physics;
	
	static {
		DEFAULT_INSTRUCTOR_DEPARTMENT.addMajor(DEFAULT_INSTRUCTOR_MAJOR);
	}
	
	/**
	 * Helper method to set up a dummy instructor
	 */
	public static Instructor createInstructor() {
		Instructor instructor = new Instructor(DEFAULT_INSTRUCTOR_NAME, DEFAULT_INSTRUCTOR_CWID, DEFAULT_INSTRUCTOR_DEPARTMENT);
		return instructor;
	}
	
	public static Instructor createPhysicsInstructor() {
		Instructor instructor = new Instructor(DEFAULT_PHYSICS_INSTRUCTOR_NAME, DEFAULT_PHYSICS_INSTRUCTOR_NAME, DEFAULT_PHYSICS_INSTRUCTOR_DEPARTMENT);
		return instructor;
	}
	
	public void testCreateInstructor() {
		Instructor instructor = createInstructor();
		
		assertEquals("Name is incorrect", instructor.getName(), DEFAULT_INSTRUCTOR_NAME);
		assertEquals("CWID is incorrect", instructor.getCwid(), DEFAULT_INSTRUCTOR_CWID);
		assertEquals("Department is incorrect", instructor.getDepartment(), DEFAULT_INSTRUCTOR_DEPARTMENT);
	}

}