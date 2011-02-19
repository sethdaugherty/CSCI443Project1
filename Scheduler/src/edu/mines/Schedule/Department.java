package edu.mines.Schedule;

import java.util.ArrayList;

/**
 * Represents a Department for the purpose of scheduling.
 * ENUM.
 */
public enum Department {
	CS("Computer Science", "CSCI"),
	ENG("Engineering", "ENGN"),
	MATH("Mathematics", "MATH"),
	MNG("Mining", "MNGN"),
	PHYS("Physics", "PHGN");
	
	
	private final String name;
	private final String code;
	private final ArrayList<Major> majors;
	
	static {
		CS.majors.add(Major.CompSci);
		ENG.majors.add(Major.CivilEngineering);
		ENG.majors.add(Major.ElectricalEngineering);
		ENG.majors.add(Major.MechanicalEngineering);
		MATH.majors.add(Major.Math);
		MNG.majors.add(Major.Mining);
		PHYS.majors.add(Major.Physics);
	}
	
	private Department(String name, String code) {
		this.name = name;
		this.code = code;
		this.majors = new ArrayList<Major>();
	}
	
	ArrayList<Major> getMajors() {
		return new ArrayList<Major>(majors);
	}
	
	String getName() {
		return name;
	}
	
	String getCode() {
		return code;
	}
	
	public String toString(){
		return name + " " + code;
	}
	
}
