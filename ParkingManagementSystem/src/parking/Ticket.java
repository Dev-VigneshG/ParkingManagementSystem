package parking;

public class Ticket {
	private String ticketId;
	private Vehicle vehicle;
    private ParkingLot parkingLot;
    private Floor floor;
    private Slot slot;
	public Ticket(Vehicle vehicle, ParkingLot parkingLot, Floor floor, Slot slot) {
		super();
		this.vehicle = vehicle;
		this.parkingLot = parkingLot;
		this.floor = floor;
		this.slot = slot;
		ticketId=parkingLot.getLotId()+"_"+(floor.getFloorNumber())+"_"+(slot.getSlotNumber());
	}
	public String getTicketId() {
		return ticketId;
	}
	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}
	@Override
	public String toString() {
		return "Ticket [ticketId=" + ticketId + ", vehicle=" + vehicle + ", parkingLot=" + parkingLot + ", floor="
				+ floor + ", slot=" + slot + "]";
	}
	
	
	

}
