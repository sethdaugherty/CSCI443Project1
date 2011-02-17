package edu.mines.Schedule;

public enum Major {
	CompSci("Computer Science"),
	Mining("Mining"),
	CivilEngineering("Civil Engineering"),
	MechanicalEngineering("Mechanical Engineer"),
	ElectricalEngineering("Electrical Engineering"),
	Math("Mathematics");
	
	private final String name;
	
	Major(String name) {
		this.name = name;
	}
	
	String getName() {
		return name;
	}
}
