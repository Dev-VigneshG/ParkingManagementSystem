package launcher;

import java.util.Scanner;

import parking.ParkingLot;

public class ParkingManagementLauncher {

	public static void main(String[] args) {
		System.out.println("*********WELCOME TO PARKING **********");
		ParkingLot parkingLot = null;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Possible Commands:");
			System.out.println("create_parking_lot 	<parking_lot_id> <no_of_floors> <slots_per_floor>");
			System.out.println("park_vehicle <vehicle_type> <reg_no> <color>");
			System.out.println("unpark_vehicle <ticket_id>");
			System.out.println("display <display_types> <vehicle_type>");
			System.out.println("<display_types> : free_count,free_slots,occupied_slots");
			System.out.println("exit");
			System.out.println("Enter Your Command:");
			String command = scanner.nextLine();
			String splitCommand[] = command.split(" ");
			if (splitCommand[0].equalsIgnoreCase("create_parking_lot")) {
				if (splitCommand.length != 4) {
					System.out.println("Invalid arguments");
					continue;
				}
				String parkingId = splitCommand[1];
				int noOfFloors = Integer.parseInt(splitCommand[2]);
				int noOfSlots = Integer.parseInt(splitCommand[3]);
				parkingLot = new ParkingLot(noOfFloors, noOfSlots, parkingId);

			} else if (splitCommand[0].equalsIgnoreCase("park_vehicle")) {
				if (parkingLot == null) {
					System.out.println("Please Create parking lot!");
					continue;
				}
				if (splitCommand.length != 4) {
					System.out.println("Invalid arguments");
					continue;
				}
				String vehicleType = splitCommand[1];
				String vehicleRegisterNumber = splitCommand[2];
				String color = splitCommand[3];
				parkingLot.parkVehicle(parkingLot, vehicleType, vehicleRegisterNumber, color);

			} else if (splitCommand[0].equalsIgnoreCase("unpark_vehicle")) {
				if (splitCommand.length != 2) {
					System.out.println("Invalid arguments");
					continue;
				}
				String ticketId=splitCommand[1];
				parkingLot.unParkVehicle(ticketId);

			} else if (splitCommand[0].equalsIgnoreCase("display")) {
				if (splitCommand.length != 3) {
					System.out.println("Invalid arguments");
					continue;
				}
				String type=splitCommand[1];
				String vehicleType=splitCommand[2];
				parkingLot.display(type, vehicleType);

			} else if (splitCommand[0].equalsIgnoreCase("exit")) {
				System.out.println("Thank you!");
				break;
			}
			else
			{
				System.out.println("Invalid command!");
			}

		}
		scanner.close();
	}
}
