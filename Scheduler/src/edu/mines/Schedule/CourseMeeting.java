package edu.mines.Schedule;

import java.util.Date;

public class CourseMeeting {
	private Course course;
	private Classroom classroom;
	private Date meetingTime;
	private int meetingLength;

	public CourseMeeting(Course course, Classroom room, Date time, int length) {
		this.course = course;
		this.classroom = room;
		this.meetingTime = time;
		this.meetingLength = length;
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

	public void setCourse(Course course) {
		this.course = course;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}

	public Date getMeetingTime() {
		return meetingTime;
	}

	public void setMeetingTime(Date time) {
		this.meetingTime = time;
	}

	public int getMeetingLength() {
		return meetingLength;
	}

	public void setMeetingLength(int length) {
		this.meetingLength = length;
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
}
