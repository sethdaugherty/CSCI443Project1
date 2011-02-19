package edu.mines.Schedule;

import java.util.Date;

public class CourseMeeting {
	private Course course;
	private Classroom classroom;
	private Date meetingTime;
	private int meetingLength;
	private int numEnrolledStudents;

	public CourseMeeting(Course course, Classroom room, Date time, int length) {
		this.course = course;
		this.classroom = room;
		this.meetingTime = time;
		this.meetingLength = length;
		this.numEnrolledStudents = 0;
	}

	public Date getEndTime() {
		long endTime = meetingTime.getTime() + getMilliSeconds(meetingLength);
		return new Date(endTime);
	}

	public static long getMilliSeconds(int num) {
		return 60000 * num;
	}

	public Course getCourse() {
		return course;
	}


	public Classroom getClassroom() {
		return classroom;
	}

	public Date getMeetingTime() {
		return meetingTime;
	}

	public int getMeetingLength() {
		return meetingLength;
	}
	
	public int getNumEnrolledStudents() {
		return numEnrolledStudents;
	}

	public String toString() {
		return getCourse() + " " + getClassroom() + " " + getMeetingTime()
				+ " " + getMeetingLength();

	}

	public boolean overlap(CourseMeeting otherMeeting) {
		Date otherStartTime = otherMeeting.getMeetingTime();
		Date otherEndTime = otherMeeting.getEndTime();
		
		// Check for start time being the same
		if (this.meetingTime == otherStartTime)
			return true;
		// Check for ending at the same time
		else if (this.getEndTime() == otherEndTime)
			return true;
		// Check for one starting before and ending after the other starts
		else if (this.meetingTime.before(otherStartTime)
				 && this.getEndTime().after(otherStartTime))
			return true;
		// Check for previous situation reversed
		else if (otherStartTime.before(this.meetingTime)
				 && otherEndTime.after(this.meetingTime))
			return true;
		// Otherwise return false
		else
			return false;
	}
	
	public boolean isFull() {
		return numEnrolledStudents == classroom.getMaxCapacity();
	}
	
	public boolean addStudent() {
		if (isFull())
			return false;
		else {
			numEnrolledStudents++;
			return true;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		CourseMeeting c = (CourseMeeting) obj;
		
		if (this.course != c.getCourse())
			return false;
		else if (this.classroom != c.getClassroom())
			return false;
		else if (this.meetingTime != c.getMeetingTime())
			return false;
		else if (this.meetingLength != c.getMeetingLength())
			return false;
		else if (this.numEnrolledStudents != c.getNumEnrolledStudents())
			return false;
		
		return true;
	}
}
