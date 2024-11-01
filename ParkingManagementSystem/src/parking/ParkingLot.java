package parking;

import java.util.ArrayList;

public class ParkingLot {
	private int numberOfFloors;
	private int numberOfSlots;
	private String lotId;
	private ArrayList<Floor> floors;

	public ParkingLot(int numberOfFloors, int numberOfSlots, String lotId) {
		this.numberOfFloors = numberOfFloors;
		this.numberOfSlots = numberOfSlots;
		this.lotId = lotId;
		floors = new ArrayList<Floor>();
		addFloors();
	}

	public void addFloors() {
		for (int i = 0; i < numberOfFloors; i++) {
			floors.add(new Floor(i + 1, numberOfSlots));
		}
	}

	public void parkVehicle(ParkingLot parkingLot, String type, String registerNumber, String color) {
		boolean isParked = false;
		for (Floor floor : parkingLot.floors) {
			for (Slot slot : floor.slots) {
				if (!slot.isParked() && slot.getType().equalsIgnoreCase(type)) {
					Vehicle vehicle = new Vehicle(type, registerNumber, color);
					Ticket ticket = new Ticket(vehicle, parkingLot, floor, slot);
					if (type.equalsIgnoreCase("car"))
						floor.parkedCar++;
					else if (type.equalsIgnoreCase("bike"))
						floor.parkedBike++;
					else if (type.equalsIgnoreCase("truck"))
						floor.parkedTruck++;
					slot.isParked = true;
					System.out.println("Your vehicle parked ID:" + ticket.getTicketId());
					isParked = true;
					return;

				}

			}
		}
		if (!isParked) {
			System.out.println("Parking lot is full");

		}

	}

	public void unParkVehicle(String ticketId) {
		String[] ticket = ticketId.split("_");
		int floorNumber = Integer.parseInt(ticket[1]);
		int slotNumber = Integer.parseInt(ticket[2]);
		Floor floor = floors.get(floorNumber - 1);
		Slot slot = floor.slots.get(slotNumber - 1);
		if (slot.isParked() == false) {
			System.out.println("You are Already Unparked or ticket id is wrong!");
			return;
		}
		slot.ticket = null;
		slot.setParked(false);
		String type=slot.getType();
		if (type.equalsIgnoreCase("car"))
			floor.parkedCar--;
		else if (type.equalsIgnoreCase("bike"))
			floor.parkedBike--;
		else if(type.equalsIgnoreCase("truck"))
		    floor.parkedTruck--;
		System.out.println("Your Vehicle is unparked");

	}

	public void display(String type, String vechicleType) {
		if (type.equalsIgnoreCase("free_count")) {
			printFreeCount(vechicleType);

		} else if (type.equalsIgnoreCase("free_slots")) {
			printFreeSlots(vechicleType);

		} else if (type.equalsIgnoreCase("occupied_slots")) {
			printOccupiedSlots(vechicleType);
		}

	}

	public void printFreeCount(String vechicleType) {
		if (vechicleType.equalsIgnoreCase("car")) {
			int floorTotalCar = numberOfSlots - 3;
			for (Floor floor : floors) {
				System.out.println("Free slots for Car  on Floor " + (floors.indexOf(floor) + 1) + " : "
						+ (floorTotalCar - floor.parkedCar));
			}

		} else if (vechicleType.equalsIgnoreCase("bike")) {
			int floorTotalBike = 2;
			for (Floor floor : floors) {
				System.out.println("Free slots for Bike  on Floor " + (floors.indexOf(floor) + 1) + " : "
						+ (floorTotalBike - floor.parkedBike));
			}

		} else if (vechicleType.equalsIgnoreCase("truck")) {
			int floorTotalTruck = 1;
			for (Floor floor : floors) {
				System.out.println("Free slots for Bike  on Floor " + (floors.indexOf(floor) + 1) + " : "
						+ (floorTotalTruck - floor.parkedBike));
			}

		}
	}

	public void printFreeSlots(String type) {
		for (Floor floor : floors) {
			System.out.print("Free slots for " + type + " on Floor " + (floors.indexOf(floor) + 1) + ":");
			for (Slot slot : floor.slots) {
				if (slot.isParked() == false && slot.getType().equals(type)) {
					System.out.print((floor.slots.indexOf(slot) + 1) + " ");

				}
			}
			System.out.println();
		}
	}

	public void printOccupiedSlots(String type) {
		for (Floor floor : floors) {
			System.out.print("Occupied slots for " + type + " on Floor " + (floors.indexOf(floor) + 1) + ":");
			for (Slot slot : floor.slots) {
				if (slot.isParked() == true && slot.getType().equals(type)) {
					System.out.print((floor.slots.indexOf(slot) + 1) + " ");

				}
			}
			System.out.println();
		}
	}

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

}
