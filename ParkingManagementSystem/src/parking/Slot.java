package parking;

public class Slot {
	String type;
	boolean isParked;
	Ticket ticket;
    int slotNumber;
	public Slot(int slotNumber,String type, boolean isParked) {
		super();
		this.slotNumber=slotNumber;
		this.type = type;
		this.isParked = isParked;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isParked() {
		return isParked;
	}

	public void setParked(boolean isParked) {
		this.isParked = isParked;
	}

	public int getSlotNumber() {
		return this.slotNumber;
	}

}
