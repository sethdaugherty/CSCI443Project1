package edu.mines.Schedule;

import java.util.ArrayList;
import junit.framework.TestCase;

public class StudentTest extends TestCase {

	public static final String DEFAULT_STUDENT_NAME = "Bob Joe";
	public static final String DEFAULT_STUDENT_CWID = "12345678";
	public static final ArrayList<Major> DEFAULT_STUDENT_MAJORS = new ArrayList<Major>();
	public static final Major DEFAULT_STUDENT_MAJOR = Major.CompSci;
	public static final ArrayList<Course> DEFAULT_STUDENT_PREV_COURSES = CourseTest.DEFAULT_PRE_REQS;
	public static final ArrayList<Course> DEFAULT_STUDENT_PREV_COURSES_2 = CourseTest.DEFAULT_PRE_REQS_2;
	static {
		DEFAULT_STUDENT_MAJORS.add(DEFAULT_STUDENT_MAJOR);
	}

	/**
	 * Helper method to set up a dummy Student
	 */
	public static Student createStudent() {
		Student student = new Student(DEFAULT_STUDENT_NAME,
				DEFAULT_STUDENT_CWID, DEFAULT_STUDENT_MAJORS,
				DEFAULT_STUDENT_PREV_COURSES);
		return student;
	}

	public static Student createStudent2() {
		Student student = new Student(DEFAULT_STUDENT_NAME,
				DEFAULT_STUDENT_CWID, DEFAULT_STUDENT_MAJORS,
				DEFAULT_STUDENT_PREV_COURSES_2);
		return student;
	}

	public void testCreateStudent() {
		Student student = createStudent();

		assertEquals("Name is incorrect", student.getName(),
				DEFAULT_STUDENT_NAME);
		assertEquals("CWID is incorrect", student.getCwid(),
				DEFAULT_STUDENT_CWID);
		assertEquals("Major is incorrect", student.getMajor().contains(
				DEFAULT_STUDENT_MAJOR), true);
		assertEquals("Number of majors is incorrect",
				student.getMajor().size(), DEFAULT_STUDENT_MAJORS.size());
	}

}
