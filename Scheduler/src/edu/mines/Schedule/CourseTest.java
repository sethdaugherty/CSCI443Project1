package edu.mines.Schedule;

import junit.framework.TestCase;
import java.util.ArrayList;

public class CourseTest extends TestCase {

	public static final String DEFAULT_COURSE_NUMBER = "101";
	public static final String DEFAULT_COURSE_NAME = "Intro to Computer Science";
	public static final double DEFAULT_CREDIT_NUMBER = 3;
	public static final ArrayList<String> DEFAULT_COURSE_TEXTBOOKS = new ArrayList<String>();
	public static final String DEFAULT_TEXTBOOK = "Computer Science Book";
	public static final Department DEFAULT_DEPARTMENT = new Department(
			"Computer Science", "CSCI");
	public static final ArrayList<Course> DEFAULT_PRE_REQS = new ArrayList<Course>();
	public static final ArrayList<Course> DEFAULT_PRE_REQS_2 = new ArrayList<Course>();
	public static final Course DEFAULT_COURSE = createCourse();
	public static final Course DEFAULT_COURSE_2 = createCourse2();
	static {
		DEFAULT_COURSE_TEXTBOOKS.add(DEFAULT_TEXTBOOK);
		DEFAULT_PRE_REQS_2.add(DEFAULT_COURSE);
	}

	public static Course createCourse() {
		Course course = new Course(DEFAULT_COURSE_NUMBER, DEFAULT_COURSE_NAME, DEFAULT_DEPARTMENT, DEFAULT_CREDIT_NUMBER,
				DEFAULT_COURSE_TEXTBOOKS, DEFAULT_PRE_REQS);
		return course;
	}

	public static Course createCourse2() {
		Course course = new Course(DEFAULT_COURSE_NUMBER, DEFAULT_COURSE_NAME,
				DEFAULT_DEPARTMENT, DEFAULT_CREDIT_NUMBER,
				DEFAULT_COURSE_TEXTBOOKS, DEFAULT_PRE_REQS_2);
		return course;
	}

	public void testCreateStudent() {
		Course course = createCourse();

		assertEquals("Course Number is incorrect", course.getCourseNumber(),
				DEFAULT_COURSE_NUMBER);
		assertEquals("Course Name is incorrect", course.getCourseName(),
				DEFAULT_COURSE_NAME);
		assertEquals("Credit Number is incorrect", course.getNumCredits(),
				DEFAULT_CREDIT_NUMBER);
		assertEquals("Textbooks are incorrect", course.getTextBooks().contains(
				DEFAULT_TEXTBOOK), true);
	}

}
