package edu.mines.Schedule;

public class Classroom {
	private String roomNumber;
	private String building;
	private int maxCapacity;
	
	public String getRoomNumber(){
		return roomNumber;
	}
	
	public void setRoomNumber(String roomNumber){
		this.roomNumber = roomNumber;
	}
	
	public String getBuilding(){
		return building;
	}
	
	public void setBuilding(String building){
		this.building = building;
	}
	
	public int getMaxCapacity(){
		return maxCapacity;
	}
	
	public void setMaxCapacity(int maxCapacity){
		this.maxCapacity = maxCapacity;
	}
}
