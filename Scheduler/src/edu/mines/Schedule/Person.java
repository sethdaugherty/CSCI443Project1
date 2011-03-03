package edu.mines.Schedule;

/**
 * Represents a Person for the purpose of scheduling at CSM.
 */
public class Person {
	protected String name;
	protected String cwid;

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
