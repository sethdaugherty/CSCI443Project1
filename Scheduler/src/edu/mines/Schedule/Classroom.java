package edu.mines.Schedule;

/**
 * Represents a Classroom for the purpose of scheduling.
 * ENUM.
 */
public enum Classroom {
	Test("101", "Somewhere", 2), 
	GC249("249", "Green Center", 30), 
	CTLM102("102", "Center For Learning Media", 100), 
	CO209("209", "Coolbaugh Hall", 200);

	private String roomNumber;
	private String building;
	private int maxCapacity;

	private Classroom(String roomNumber, String building, int maxCapacity) {
		this.roomNumber = roomNumber;
		this.building = building;
		this.maxCapacity = maxCapacity;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public String getBuilding() {
		return building;
	}

	public int getMaxCapacity() {
		return maxCapacity;
	}

}
