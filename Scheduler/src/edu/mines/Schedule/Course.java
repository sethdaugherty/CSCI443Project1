package edu.mines.Schedule;

import java.util.Set;
import java.util.HashSet;
import java.lang.Double;

/**
 * Represents a course for the purpose of scheduling.
 */
final class Course {
  private final String courseNumber;
  private final String courseName;
  private final double numCredits;
  private final Set<String> textBooks;
  private final Set<Course> preReqs;
  private final Department department;

  /**
   * We chose not to use the Builder pattern here for 2 reasons 1) There really
   * isn't anything ambiguous about the constructor except for the first two
   * arguments. The caller is unlikely to be confused. 2) There are no optional
   * parameters. The Builder pattern is most useful when you have telescoping
   * constructors due to optional arguments, which is not the case Since the
   * only real argument in favor of using a Builder is the possible confusion
   * over the two string arguments, we decided the extra complexity was
   * unnecessary.
   * 
   * @param courseNumber
   * @param courseName
   * @param department
   * @param numCredits
   * @param textBooks
   * @param preReqs
   */
  Course(String courseNumber, String courseName, Department department,
      double numCredits, Set<String> textBooks, Set<Course> preReqs) {
    this.courseNumber = courseNumber;
    this.courseName = courseName;
    this.department = department;
    if (numCredits >= 0)
      this.numCredits = numCredits;
    else
      throw new IllegalArgumentException(
          "Cannot have negative number of credits");
    this.textBooks = new HashSet<String>(textBooks);
    this.preReqs = new HashSet<Course>(preReqs);
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

  Set<String> getTextBooks() {
    return new HashSet<String>(textBooks);
  }

  Set<Course> getPreReqs() {
    return new HashSet<Course>(preReqs);

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

  @Override
  public int hashCode() {
    int hash = 7;

    hash = 31 * hash + courseName.hashCode();
    hash = 31 * hash + courseNumber.hashCode();
    hash = 31 * hash + new Double(numCredits).hashCode();
    hash = 31 * hash + department.hashCode();
    hash = 31 * hash + textBooks.hashCode();

    return hash;
  }

}
