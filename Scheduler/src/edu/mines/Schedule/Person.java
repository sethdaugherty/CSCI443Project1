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
	public void setName(String name) {
		this.name = name;
	}
	public String getCwid() {
		return cwid;
	}
	public void setCwid(String cwid) {
		this.cwid = cwid;
	}
	
}