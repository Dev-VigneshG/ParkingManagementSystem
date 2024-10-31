package parking;

import java.util.ArrayList;

public class ParkingLot {
	private int numberOfFloors;
	private int numberOfSlots;
	private String lotId;
	private ArrayList<Floor> floors;

	public int getNumberOfFloors() {
		return numberOfFloors;
	}

	public void setNumberOfFloors(int numberOfFloors) {
		this.numberOfFloors = numberOfFloors;
	}

	public int getNumberOfSlots() {
		return numberOfSlots;
	}

	public void setNumberOfSlots(int numberOfSlots) {
		this.numberOfSlots = numberOfSlots;
	}

	public String getLotId() {
		return lotId;
	}

	public void setLotId(String lotId) {
		this.lotId = lotId;
	}

	public ParkingLot(int numberOfFloors, int numberOfSlots, String lotId) {
		this.numberOfFloors = numberOfFloors;
		this.numberOfSlots = numberOfSlots;
		this.lotId = lotId;
		addFloors();
	}

	public void addFloors() {
		for (int i = 0; i < numberOfFloors; i++) {
			floors.add(new Floor(i+1,numberOfSlots));
		}
	}

	public void parkVehicle(String type, String registerNumber, String color) {

	}

	public void unParkVehicle(int ticketId) {

	}

	public void display() {

	}

}
