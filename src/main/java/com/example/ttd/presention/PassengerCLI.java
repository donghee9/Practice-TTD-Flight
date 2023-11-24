package com.example.ttd.presention;
import com.example.ttd.controller.PassengerController;
import com.example.ttd.domain.dto.PassengerDTO;

import java.util.Scanner;

public class PassengerCLI {
    private PassengerController passengerController;
    private  Scanner scanner;

    public PassengerCLI(PassengerController passengerController) {
        this.passengerController = passengerController;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nPassenger Services");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Recharge Points");
            System.out.println("4. Unsubscribe");
            System.out.println("5. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    handleRegistration();
                    break;
                case 2:
                    handleLogin();
                    break;
                case 3:
                    handleRechargePoints();
                    break;
                case 4:
                    handleUnsubscribe();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void handleRegistration() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter user login ID:");
        String userLoginId = scanner.nextLine();

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter phone:");
        String phone = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Enter point");
        double points =scanner.nextDouble();

        PassengerDTO passengerDTO = PassengerDTO.of(name, userLoginId, email, phone, password,points);
        passengerController.enrollment(passengerDTO);
    }

    private void handleLogin() {
        System.out.println("Enter user login ID:");
        String userId = scanner.nextLine();

        System.out.println("Enter password:");
        String userPw = scanner.nextLine();

        passengerController.checkIn(userId, userPw);
    }

    private void handleRechargePoints() {
        System.out.println("Enter user login ID:");
        String userId = scanner.nextLine();

        System.out.println("Enter password:");
        String userPw = scanner.nextLine();

        System.out.println("Enter points to add:");
        double points = scanner.nextDouble();
        scanner.nextLine();

        passengerController.addPoint(userId, userPw, points);
    }

    private void handleUnsubscribe() {
        System.out.println("Enter user login ID:");
        String userId = scanner.nextLine();

        System.out.println("Enter password:");
        String userPw = scanner.nextLine();

        passengerController.cancelEnrollment(userId, userPw);
    }
}

