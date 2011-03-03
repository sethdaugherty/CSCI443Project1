package edu.mines.Schedule;

import java.util.ArrayList;

/**
 * Represents a Student for the purpose of scheduling. Extends {@link Person}.
 */
public class Student
		extends Person {
	public Student(String name, String cwid, ArrayList<Major> majors, ArrayList<Course> previousCourses) {
		super(name, cwid);
		this.majors = new ArrayList<Major>(majors);
		this.previousCourses = new ArrayList<Course>(previousCourses);
	}

	private static final double SOPHMORE_LEVEL = 30;
	private static final double JUNIOR_LEVEL = 60;
	private static final double SENIOR_LEVEL = 90;

	private final ArrayList<Major> majors;
	private final ArrayList<Course> previousCourses;

	public ArrayList<Major> getMajor() {
		return new ArrayList<Major>(majors);
	}

	public ArrayList<Course> getCourses() {
		return new ArrayList<Course>(previousCourses);
	}

	public String getStatus() {
		double sum = 0;
		
		for (Course course : previousCourses) {
			sum = course.getNumCredits();
		}

		if (sum < SOPHMORE_LEVEL) {
			return "Freshman";
		} else if (sum < JUNIOR_LEVEL) {
			return "Sophmore";
		} else if (sum < SENIOR_LEVEL) {
			return "Junior";
		} else
			return "Senior";
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(name);
		builder.append(" ");
		builder.append(cwid);
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		Student s = (Student) obj;
		if(!(obj instanceof Student))
			return false;
		else if (this.getName() != s.getName())
			return false;
		else if (this.getCwid() != s.getCwid())
			return false;
		else if (!this.majors.containsAll(s.getMajor()) || this.majors.size() != s.getMajor().size())
			return false;
		else if (!this.previousCourses.containsAll(s.getCourses())
				|| this.previousCourses.size() != s.getCourses().size())
			return false;

		return true;
	}
	
	@Override
	public int hashCode() {
	  int hash=7;
	  
	  hash = 31*hash + name.hashCode();
	  hash = 31*hash + cwid.hashCode();
	  hash = 31*hash + majors.hashCode();
	  hash = 31*hash + previousCourses.hashCode();
	  
	  return hash;
	}
}
