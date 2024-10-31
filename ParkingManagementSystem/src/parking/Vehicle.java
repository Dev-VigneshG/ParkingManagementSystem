package parking;

public class Vehicle {
	String type;
	String registerNumber;
	String ownerName;
	String color;

	public Vehicle(String type, String registerNumber, String ownerName, String color) {
		super();
		this.type = type;
		this.registerNumber = registerNumber;
		this.ownerName = ownerName;
		this.color = color;
	}

}

class Car extends Vehicle {

	public Car(String type, String registerNumber, String ownerName, String color) {
		super(type, registerNumber, ownerName, color);

	}
}

class Bike extends Vehicle {

	public Bike(String type, String registerNumber, String ownerName, String color) {
		super(type, registerNumber, ownerName, color);

	}
}

class Truck extends Vehicle {

	public Truck(String type, String registerNumber, String ownerName, String color) {
		super(type, registerNumber, ownerName, color);

	}
}
