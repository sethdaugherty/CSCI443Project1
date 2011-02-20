package edu.mines.Schedule;

/**
 * Represents an Instructor for the purpose of scheduling.
 * Extends {@link Person}.
 */
class Instructor extends Person {
	private final Department department;
	
	Instructor(String name, String cwid, Department department) {
		super(name, cwid);
		this.department = department;
	}
	
	Department getDepartment() {
		return department;
	}
	
	@Override
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
