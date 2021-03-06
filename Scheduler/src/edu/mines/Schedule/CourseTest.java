package edu.mines.Schedule;

import java.util.Set;
import java.util.HashSet;
import junit.framework.TestCase;

/**
 * Tests {@link Course} to ensure it operates correctly.
 */
public class CourseTest extends TestCase {

	public static final String DEFAULT_COURSE_NUMBER = "101";
	public static final String DEFAULT_COURSE_NAME = "Intro to Computer Science";
	public static final double DEFAULT_CREDIT_NUMBER = 3;
	public static final double DEFAULT_CREDIT_NUMBER_2 = 60;
	public static final Set<String> DEFAULT_COURSE_TEXTBOOKS = new HashSet<String>();
	public static final String DEFAULT_TEXTBOOK = "Computer Science Book";
	public static final Department DEFAULT_DEPARTMENT = Department.CS;
	public static final String DEFAULT_PHYSICS_COURSE_NUMBER = "200";
	public static final String DEFAULT_PHYSICS_COURSE_NAME = "Introductory Mechanics";
	public static final double DEFAULT_PHYSICS_CREDIT_NUMBER = 4.5;
	public static final Set<String> DEFAULT_PHYSICS_COURSE_TEXTBOOKS = new HashSet<String>();
	public static final String DEFAULT_PHYSICS_TEXTBOOK = "A Physics Book";
	public static final Department DEFAULT_PHYSICS_DEPARTMENT = Department.PHYS;
	public static final Set<Course> DEFAULT_PRE_REQS = new HashSet<Course>();
	public static final Set<Course> DEFAULT_PRE_REQS_2 = new HashSet<Course>();
	public static final Set<Course> DEFAULT_PRE_REQS_3 = new HashSet<Course>();
	public static final Set<Course> DEFAULT_PRE_REQS_4 = new HashSet<Course>();
	public static final Set<Course> DEFAULT_PRE_REQS_5 = new HashSet<Course>();
	public static final Set<Course> DEFAULT_PHYSICS_PRE_REQS = new HashSet<Course>();
	public static final Course DEFAULT_COURSE = createCourse();
	public static final Course DEFAULT_COURSE_WITH_PREREQ = createCourseWithPreReq();
	public static final Course DEFAULT_COURSE_2 = createCourseWithPreReq();
	public static final Course DEFAULT_COURSE_3 = createCourse3();
	public static final Course DEFAULT_COURSE_4 = createCourse4();
	public static final Course DEFAULT_COURSE_5 = createCourse5();
	static {
		DEFAULT_COURSE_TEXTBOOKS.add(DEFAULT_TEXTBOOK);
		DEFAULT_PHYSICS_COURSE_TEXTBOOKS.add(DEFAULT_PHYSICS_TEXTBOOK);
		DEFAULT_PRE_REQS_2.add(DEFAULT_COURSE);
		DEFAULT_PRE_REQS_3.add(DEFAULT_COURSE_3);
		DEFAULT_PRE_REQS_4.add(DEFAULT_COURSE_4);
		DEFAULT_PRE_REQS_5.add(DEFAULT_COURSE_5);
	}

	public static Course createCourse() {
		Course course = new Course(DEFAULT_COURSE_NUMBER, DEFAULT_COURSE_NAME, DEFAULT_DEPARTMENT,
				DEFAULT_CREDIT_NUMBER, DEFAULT_COURSE_TEXTBOOKS, DEFAULT_PRE_REQS);
		return course;
	}

	public static Course createCourseWithPreReq() {
		Course course = new Course(DEFAULT_COURSE_NUMBER, DEFAULT_COURSE_NAME, DEFAULT_DEPARTMENT,
				DEFAULT_CREDIT_NUMBER, DEFAULT_COURSE_TEXTBOOKS, DEFAULT_PRE_REQS_2);
		return course;
	}

	public static Course createCourse3() {
		Course course = new Course(DEFAULT_COURSE_NUMBER, DEFAULT_COURSE_NAME, DEFAULT_DEPARTMENT,
				DEFAULT_CREDIT_NUMBER_2, DEFAULT_COURSE_TEXTBOOKS, DEFAULT_PRE_REQS);
		return course;
	}

	public static Course createCourse4() {
		Course course = new Course(DEFAULT_COURSE_NUMBER, DEFAULT_COURSE_NAME, DEFAULT_DEPARTMENT,
				DEFAULT_CREDIT_NUMBER_2 - 1, DEFAULT_COURSE_TEXTBOOKS, DEFAULT_PRE_REQS);
		return course;
	}

	public static Course createCourse5() {
		Course course = new Course(DEFAULT_COURSE_NUMBER, DEFAULT_COURSE_NAME, DEFAULT_DEPARTMENT,
				DEFAULT_CREDIT_NUMBER_2 + 30, DEFAULT_COURSE_TEXTBOOKS, DEFAULT_PRE_REQS);
		return course;
	}
	
	public static Course createCourse6() {
		Course course = new Course(DEFAULT_COURSE_NUMBER, DEFAULT_COURSE_NAME, DEFAULT_DEPARTMENT,
				DEFAULT_CREDIT_NUMBER - 4, DEFAULT_COURSE_TEXTBOOKS, DEFAULT_PRE_REQS);
		return course;
	}

	public static Course createPhysicsCourse() {
		Course course = new Course(DEFAULT_PHYSICS_COURSE_NUMBER, DEFAULT_PHYSICS_COURSE_NAME,
				DEFAULT_PHYSICS_DEPARTMENT, DEFAULT_PHYSICS_CREDIT_NUMBER,
				DEFAULT_PHYSICS_COURSE_TEXTBOOKS, DEFAULT_PHYSICS_PRE_REQS);
		return course;
	}

	public void testCreateStudent() {
		Course course = createCourse();

		assertEquals("Course Number is incorrect", course.getCourseNumber(), DEFAULT_COURSE_NUMBER);
		assertEquals("Course Name is incorrect", course.getCourseName(), DEFAULT_COURSE_NAME);
		assertEquals("Credit Number is incorrect", course.getNumCredits(), DEFAULT_CREDIT_NUMBER);
		assertEquals("Textbooks are incorrect", course.getTextBooks().contains(DEFAULT_TEXTBOOK), true);
	}
	
	public void testIllegalCreditNumber(){
		try{
			Course course = createCourse6();
			fail("Didn't detect negative credit conflict");
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
		
		
	}

}
