package edu.mines.Schedule;

/**
 * Represents a Major for the purpose of scheduling. ENUM.
 */
enum Major {
	CompSci("Computer Science"), Mining("Mining"), CivilEngineering("Civil Engineering"), MechanicalEngineering(
			"Mechanical Engineer"), ElectricalEngineering("Electrical Engineering"), Math("Mathematics"), Physics(
			"Physics");

	private final String name;

	private Major(String name) {
		this.name = name;
	}

	String getName() {
		return name;
	}
}
