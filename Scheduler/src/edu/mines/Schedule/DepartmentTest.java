package edu.mines.Schedule;

import junit.framework.TestCase;

public class DepartmentTest extends TestCase {

	public void testAddMajor() {
		
		Department department = new Department("Computer Science", "CSCI");
		assertEquals("Majors should be empty", department.getMajors().size(), 0);
		Major major = Major.CompSci;
		department.addMajor(major);
		assertEquals("Majors should be empty", department.getMajors().contains(major), true);
	}

	public void testRemoveMajor() {
		fail("Not yet implemented");
	}

}
