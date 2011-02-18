package edu.mines.Schedule;

import junit.framework.TestCase;
import java.util.ArrayList;

public class CourseTest extends TestCase {
	
	public static final String DEFAULT_COURSE_NUMBER = "CSCI 1";
	public static final String DEFAULT_COURSE_NAME = "Computer Science";
	public static final double DEFAULT_CREDIT_NUMBER = 3.0;
	public static final ArrayList<String> DEFAULT_COURSE_TEXTBOOKS = new ArrayList<String>();
	public static final String DEFAULT_TEXTBOOK = "Computer Science 1";
	static {
		DEFAULT_COURSE_TEXTBOOKS.add(DEFAULT_TEXTBOOK);
	}
	
	public static Course createCourse() {
		Course course = new Course(DEFAULT_COURSE_NUMBER, DEFAULT_COURSE_NAME, DEFAULT_CREDIT_NUMBER, DEFAULT_COURSE_TEXTBOOKS);
		return course;
	}
	
	public void testCreateStudent() {
		Course course = createCourse();
		
		assertEquals("Course Number is incorrect", course.getCourseNumber(), DEFAULT_COURSE_NUMBER);
		assertEquals("Course Name is incorrect", course.getCourseName(), DEFAULT_COURSE_NAME);
		assertEquals("Credit Number is incorrect", course.getNumCredits(), DEFAULT_CREDIT_NUMBER);
		assertEquals("Textbooks are incorrect", course.getTextBooks().contains(DEFAULT_TEXTBOOK), true);
	}

}
