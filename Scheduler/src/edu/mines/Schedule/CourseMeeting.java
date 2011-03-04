package edu.mines.Schedule;

import java.util.Date;

/**
 * Represents a specific meeting of a {@link Course} in a {@link Classroom} at a
 * specific time.
 * 
 * Includes methods to retrieve the time the class ends and check if one
 * instance's meeting time overlaps with another's.
 * 
 * Also, includes method to add to the number of currently enrolled students,
 * for the purpose of ensuring the Classroom is not full.
 * 
 * Left Mutable, because CourseMeetings can potentially change Classrooms or
 * change meeting time without requiring a new object to be created
 */
class CourseMeeting {
  private Course course;
  private Classroom classroom;
  private Date meetingTime;
  private int meetingLength;
  private int numEnrolledStudents;

  CourseMeeting(Course course, Classroom room, Date time, int length) {
    this.course = course;
    this.classroom = room;
    this.meetingTime = time;
    this.meetingLength = length;
    this.numEnrolledStudents = 0;
  }

  Date getEndTime() {
    long endTime = meetingTime.getTime() + getMilliSeconds(meetingLength);
    return new Date(endTime);
  }

  static long getMilliSeconds(int num) {
    return 60000 * num;
  }

  Course getCourse() {
    return course;
  }

  Classroom getClassroom() {
    return classroom;
  }

  Date getMeetingTime() {
    return meetingTime;
  }

  int getMeetingLength() {
    return meetingLength;
  }

  int getNumEnrolledStudents() {
    return numEnrolledStudents;
  }

  /**
   * Checks if {@link otherMeeting} conflicts with this by occupying the same
   * classroom at the same time
   * 
   * @param otherMeeting
   * @return
   */
  boolean conflictsWith(CourseMeeting otherMeeting) {
    return sameClassroomAs(otherMeeting) && overlap(otherMeeting);
  }

  /**
   * Checks if {@link otherMeeting} occupies the same {@link Classroom} as this.
   * 
   * @param otherMeeting
   * @return true if they do, false otherwise
   */
  boolean sameClassroomAs(CourseMeeting otherMeeting) {
    return this.classroom == otherMeeting.getClassroom();
  }

  /**
   * Checks if {@link otherMeeting} and this have {@link meetingTime}'s that
   * overlap
   * 
   * @param otherMeeting
   * @return true if they overlap, false otherwise
   */
  boolean overlap(CourseMeeting otherMeeting) {
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

  boolean isFull() {
    return numEnrolledStudents == classroom.getMaxCapacity();
  }

  /**
   * Increases the {@link numEnrolledStudents} variable by one if there is room
   * in the {@link Classroom}.
   * 
   * @return false if room is full, true otherwise
   */
  boolean addStudent() {
    if (isFull())
      return false;
    else {
      numEnrolledStudents++;
      return true;
    }
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append(course.toString());
    builder.append(" Room: ");
    builder.append(classroom);
    builder.append(" Time: ");
    builder.append(meetingTime);
    return builder.toString();
  }
  
  @Override
  public boolean equals(Object obj) {
    CourseMeeting c = (CourseMeeting) obj;

    if (!this.course.equals(c.getCourse()))
      return false;
    else if (this.classroom != c.getClassroom())
      return false;
    else if (this.meetingTime != c.getMeetingTime())
      return false;
    else if (this.meetingLength != c.getMeetingLength())
      return false;

    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;

    hash = 31 * hash + course.hashCode();
    hash = 31 * hash + classroom.hashCode();
    hash = 31 * hash + meetingTime.hashCode();
    hash = 31 * hash + meetingLength;

    return hash;
  }
}
