package edu.mines.Schedule;

import java.util.ArrayList;

public class Student extends Person {
	public Student(String name, String cwid, ArrayList<Major> majors,
			ArrayList<Course> previousCourses) {
		super(name, cwid);
		this.majors = majors;
		this.previousCourses = previousCourses;
	}

	private ArrayList<Major> majors;
	private ArrayList<Course> previousCourses;

	public ArrayList<Major> getMajor() {
		return majors;
	}

	public ArrayList<Course> getCourses() {
		return previousCourses;
	}

	public String getStatus() {
		double sum = 0;
		for (Course course : previousCourses) {
			sum = course.getNumCredits();
		}
		if (sum < 30) {
			return "Freshman";
		} else if (sum < 60) {
			return "Sophmore";
		} else if (sum < 90) {
			return "Junior";
		} else
			return "Senior";
	}

	@Override
	public boolean equals(Object obj) {
		Student s = (Student) obj;

		if (this.getName() != s.getName())
			return false;
		else if (this.getCwid() != s.getCwid())
			return false;
		else if (!this.majors.containsAll(s.getMajor())
				|| this.majors.size() != s.getMajor().size())
			return false;
		else if (!this.previousCourses.containsAll(s.getCourses())
				|| this.previousCourses.size() != s.getCourses().size())
			return false;
		
		return true;
	}
}
