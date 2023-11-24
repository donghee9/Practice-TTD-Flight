package com.example.ttd;

import com.example.ttd.controller.PassengerController;
import com.example.ttd.domain.service.PassengerServiceImpl;
import com.example.ttd.infra.DataStore;
import com.example.ttd.infra.repository.Impl.PassengerRepositoryImpl;
import com.example.ttd.presention.PassengerCLI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


public class TtdApplication {

	public static void main(String[] args) {
		runCLI();
	}

	private static void runCLI() {
		Scanner scanner = new Scanner(System.in);
//		ReservationController reservationController = new ReservationController(
//				new ReservationServiceImpl(
//						new ReservationRepositoryImpl(
//								DataStore.flightsList)));

		PassengerController passengerController = new PassengerController(
				new PassengerServiceImpl(
						new PassengerRepositoryImpl(
								DataStore.passengersList)));

		while (true) {
			System.out.println("\nWelcome to FlightApp");
			System.out.println("1. Members Only");
			System.out.println("2. View and Filter Flights");
			System.out.println("3. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			switch (choice) {
				case 1:
					PassengerCLI passengerCLI = new PassengerCLI(passengerController);
					passengerCLI.start();
					break;
//				case 2:
//					ReservationCLI reservationCLI = new ReservationCLI(reservationController);
//					reservationCLI.start();
//					break;
				case 3:
					System.out.println("Exiting the application...");
					scanner.close();
					return; // Exit the application
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}

