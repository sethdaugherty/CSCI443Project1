package edu.mines.Schedule;

public class Person {
	private String name;
	private String cwid;
	
	public Person(String name, String cwid) {
		this.name = name;
		this.cwid = cwid;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCwid() {
		return cwid;
	}
	
}
