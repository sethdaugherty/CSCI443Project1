package edu.mines.Schedule;

import java.util.ArrayList;

public class Department {
	private final String name;
	private final String code;
	private ArrayList<Major> majors;
	
	Department(String name, String code) {
		this.name = name;
		this.code = code;
		this.majors = new ArrayList<Major>();
	}
	
	ArrayList<Major> getMajors() {
		return (ArrayList<Major>) majors.clone();
	}
	
	String getName() {
		return name;
	}
	
	String getCode() {
		return code;
	}
	
	boolean addMajor(Major major) {
		return majors.add(major);
	}
	
	public String toString(){
		return name + " " + code;
	}
	
}
