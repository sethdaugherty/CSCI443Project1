package edu.mines.Schedule;

import java.util.ArrayList;
import junit.framework.TestCase;

/**
 * Tests {@link Student} to ensure it operates correctly.
 */
public class StudentTest
		extends TestCase {

	static final String DEFAULT_STUDENT_NAME = "Bob Joe";
	static final String DEFAULT_STUDENT_CWID = "12345678";
	static final ArrayList<Major> DEFAULT_STUDENT_MAJORS = new ArrayList<Major>();
	static final Major DEFAULT_STUDENT_MAJOR = Major.CompSci;
	static final ArrayList<Course> DEFAULT_STUDENT_PREV_COURSES = CourseTest.DEFAULT_PRE_REQS;
	static final ArrayList<Course> DEFAULT_STUDENT_PREV_COURSES_2 = CourseTest.DEFAULT_PRE_REQS_2;
	static final ArrayList<Course> DEFAULT_STUDENT_PREV_COURSES_3 = CourseTest.DEFAULT_PRE_REQS_3;
	static final ArrayList<Course> DEFAULT_STUDENT_PREV_COURSES_4 = CourseTest.DEFAULT_PRE_REQS_4;
	static final ArrayList<Course> DEFAULT_STUDENT_PREV_COURSES_5 = CourseTest.DEFAULT_PRE_REQS_5;
	static {
		DEFAULT_STUDENT_MAJORS.add(DEFAULT_STUDENT_MAJOR);
		DEFAULT_STUDENT_PREV_COURSES_2.add(CourseTest.DEFAULT_COURSE);
	}

	/**
	 * Helper method to set up a dummy Student
	 */
	static Student createStudent() {
		Student student = new Student(DEFAULT_STUDENT_NAME, DEFAULT_STUDENT_CWID,
				DEFAULT_STUDENT_MAJORS, DEFAULT_STUDENT_PREV_COURSES);
		return student;
	}

	static Student createStudent2() {
		Student student = new Student(DEFAULT_STUDENT_NAME, DEFAULT_STUDENT_CWID,
				DEFAULT_STUDENT_MAJORS, DEFAULT_STUDENT_PREV_COURSES_2);
		return student;
	}

	static Student createStudent3() {
		Student student = new Student(DEFAULT_STUDENT_NAME, DEFAULT_STUDENT_CWID,
				DEFAULT_STUDENT_MAJORS, DEFAULT_STUDENT_PREV_COURSES_3);
		return student;
	}

	static Student createStudent4() {
		Student student = new Student(DEFAULT_STUDENT_NAME, DEFAULT_STUDENT_CWID,
				DEFAULT_STUDENT_MAJORS, DEFAULT_STUDENT_PREV_COURSES_4);
		return student;
	}

	static Student createStudent5() {
		Student student = new Student(DEFAULT_STUDENT_NAME, DEFAULT_STUDENT_CWID,
				DEFAULT_STUDENT_MAJORS, DEFAULT_STUDENT_PREV_COURSES_5);
		return student;
	}

	public void testCreateStudent() {
		Student student = createStudent();

		assertEquals("Name is incorrect", student.getName(), DEFAULT_STUDENT_NAME);
		assertEquals("CWID is incorrect", student.getCwid(), DEFAULT_STUDENT_CWID);
		assertEquals("Major is incorrect", student.getMajor().contains(DEFAULT_STUDENT_MAJOR), true);
		assertEquals("Number of majors is incorrect", student.getMajor().size(), DEFAULT_STUDENT_MAJORS
				.size());
	}

	public void testGetStatus() {
		Student student = createStudent();
		assertEquals("Credit count incorrect", student.getStatus(), "Freshman");
	}

	public void testGetStatus2() {
		Student student = createStudent3();
		assertEquals("Credit count incorrect", student.getStatus(), "Junior");
	}

	public void testGetStatus3() {
		Student student = createStudent4();
		assertEquals("Credit count incorrect", student.getStatus(), "Sophmore");
	}

	public void testGetStatus4() {
		Student student = createStudent5();
		assertEquals("Credit count incorrect", student.getStatus(), "Senior");
	}

}
