package edu.mines.Schedule;

import junit.framework.TestCase;

public class DepartmentTest extends TestCase {

	public void testDepartment() {
		Department department = Department.CS;
		Major major = Major.CompSci;
		assertEquals("Majors should conatin CompSci", department.getMajors().contains(major), true);
	}
}
