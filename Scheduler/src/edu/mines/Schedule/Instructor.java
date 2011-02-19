package edu.mines.Schedule;

public class Instructor extends Person {
	private final Department department;
	
	public Instructor(String name, String cwid, Department department) {
		super(name, cwid);
		this.department = department;
	}
	
	public Department getDepartment() {
		return department;
	}
	
	public String toString(){
		return getName() + " " + getCwid() + " " + getDepartment().getName();
	}
}
