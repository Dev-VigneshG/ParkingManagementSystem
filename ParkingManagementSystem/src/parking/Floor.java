package parking;

import java.util.ArrayList;

public class Floor {
	private int floorNumber;
	private int noOfSlots;
	int parkedCar = 0;
	int parkedTruck = 0;
	int parkedBike = 0;
    ArrayList<Slot> slots;

	public Floor(int floorNumber, int noOfSlots) {
		this.floorNumber = floorNumber;
		this.noOfSlots = noOfSlots;
		slots = new ArrayList<Slot>();
		addSlot();
	}

	public void addSlot() {
		for (int i = 0; i < noOfSlots; i++) {
			if (i == 0)
				slots.add(new Slot(i + 1, "truck", false));
			else if (i <= 2)
				slots.add(new Slot(i + 1, "bike", false));
			else
				slots.add(new Slot(i + 1, "car", false));
		}
	}

	public int getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(int floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getNoOfSlots() {
		return noOfSlots;
	}

	public void setNoOfSlots(int noOfSlots) {
		this.noOfSlots = noOfSlots;
	}

}
