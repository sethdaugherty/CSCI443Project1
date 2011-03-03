package edu.mines.Schedule;

/**
 * Represents a Person for the purpose of scheduling at CSM.
 */
abstract class Person {
	protected String name;
	protected String cwid;

	Person(String name, String cwid) {
		this.name = name;
		this.cwid = cwid;
	}

	String getName() {
		return name;
	}

	String getCwid() {
		return cwid;
	}
}
