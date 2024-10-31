package parking;

public class Ticket {
	String ticketId;
	Vehicle vehicle;
    ParkingLot parkingLot;
    Floor floor;
    Slot slot;
	public Ticket(Vehicle vehicle, ParkingLot parkingLot, Floor floor, Slot slot) {
		super();
		this.vehicle = vehicle;
		this.parkingLot = parkingLot;
		this.floor = floor;
		this.slot = slot;
		ticketId=parkingLot.getLotId()+"_"+floor.getFloorNumber()+"_"+slot.getSlotNumber();
	}
	
	

}
