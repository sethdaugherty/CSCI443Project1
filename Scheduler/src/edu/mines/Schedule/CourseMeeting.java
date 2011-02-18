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
		// The length is in minutes, so lets convert that to milliseconds
		long lengthMilli = meetingLength * 60000;
		long endTime = meetingTime.getTime() + lengthMilli;
		return new Date(endTime);
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

}
