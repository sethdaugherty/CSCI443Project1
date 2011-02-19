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
	
	@Override
	public boolean equals(Object obj) {
		Instructor i = (Instructor) obj;
		
		if (this.name != i.getName())
			return false;
		else if (this.cwid != i.getCwid())
			return false;
		else if (this.department != i.getDepartment())
			return false;
		
		return true;
	}
}
