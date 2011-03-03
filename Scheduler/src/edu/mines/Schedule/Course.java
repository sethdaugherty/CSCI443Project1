package edu.mines.Schedule;

import java.util.ArrayList;

/**
 * Represents a course for the purpose of scheduling.
 */
class Course {
	private String courseNumber;
	private String courseName;
	private double numCredits;
	private ArrayList<String> textBooks;
	private ArrayList<Course> preReqs;
	private Department department;

	Course(String courseNumber, String courseName, Department department, double numCredits,
			ArrayList<String> textBooks, ArrayList<Course> preReqs) {
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.department = department;
		this.numCredits = numCredits;
		this.textBooks = textBooks;
		this.preReqs = preReqs;
	}

	String getCourseNumber() {
		return courseNumber;
	}

	String getCourseName() {
		return courseName;
	}

	Department getDepartment() {
		return department;
	}

	double getNumCredits() {
		return numCredits;
	}

	ArrayList<String> getTextBooks() {
		return textBooks;
	}

	ArrayList<Course> getPreReqs() {
		return preReqs;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(department.getCode());
		builder.append(courseNumber);
		builder.append(" ");
		builder.append(courseName);
		return builder.toString();
	}

	@Override
	public boolean equals(Object obj) {
		Course c = (Course) obj;

		if (this.courseName != c.getCourseName())
			return false;
		else if (this.courseNumber != c.getCourseNumber())
			return false;
		else if (this.numCredits != c.getNumCredits())
			return false;
		else if (this.department != c.getDepartment())
			return false;
		else if (!this.textBooks.containsAll(c.getTextBooks())
				|| this.textBooks.size() != c.getTextBooks().size())
			return false;

		return true;
	}

}
