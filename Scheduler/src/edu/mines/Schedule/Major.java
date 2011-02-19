package edu.mines.Schedule;

/**
 * Represents a Major for the purpose of scheduling.
 * ENUM.
 */
public enum Major {
	CompSci("Computer Science"), 
	Mining("Mining"), 
	CivilEngineering("Civil Engineering"), 
	MechanicalEngineering("Mechanical Engineer"), 
	ElectricalEngineering("Electrical Engineering"), 
	Math("Mathematics"),
	Physics("Physics");

	private final String name;

	Major(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}
}
