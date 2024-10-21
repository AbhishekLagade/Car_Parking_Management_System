package com.demo.car_parking_management;

import com.demo.parking.entities.User;
import com.demo.car_parking_management.service.Userservice;
import com.demo.car_parking_management.serviceImpl.UserserviceImpl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import com.demo.parking.entities.Admin;
import com.demo.parking.entities.Car;
import com.demo.parking.entities.ParkingFees;
import com.demo.car_parking_management.service.Adminservice;
import com.demo.car_parking_management.serviceImpl.AdminserviceImpl;
import com.demo.car_parking_management.serviceImpl.CarserviceImpl;
import com.demo.car_parking_management.serviceImpl.ParkingfeesServiceImpl;
import com.demo.car_parking_management.service.ParkingFeesservice;
import com.demo.car_parking_management.serviceImpl.CarserviceImpl;


import com.demo.car_parking_management.service.Carservice;
import com.demo.car_parking_management.serviceImpl.CarserviceImpl;
import com.demo.parking.entities.Car;
import com.demo.parking.entities.ParkingFees;
public class Alloperation {

	// Service instance
	static Userservice userService = new UserserviceImpl();
	private static final Adminservice adminService = new  AdminserviceImpl();
	 private static final Carservice carService = new CarserviceImpl();
	 private static final ParkingFeesservice parkingFeesService = new ParkingfeesServiceImpl();

	static Scanner sc = new Scanner(System.in);

	// User Input method
	public static User userInputs() {
		// Collect userId from user
		//System.out.println("Enter User ID:");
		//String userId = sc.nextLine();

		// Collect first name from user
		System.out.println("Enter First Name:");
		String firstName = sc.nextLine();

		// Collect last name from user
		System.out.println("Enter Last Name:");
		String lastName = sc.nextLine();

		// Collect date of birth from user
		System.out.println("Enter Date of Birth (yyyy-mm-dd):");
		LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());

		// Collect gender from user
		System.out.println("Enter Gender:");
		String gender = sc.nextLine();

		// Collect email from user
		System.out.println("Enter Email:");
		String email = sc.nextLine();

		// Collect phone from user
		System.out.println("Enter Phone Number:");
		String phone = sc.nextLine();

		// Create and return a new User object using the provided constructor
		return new User( firstName, lastName, dateOfBirth, gender, email, phone);
	}

	// User Operations method
	public static void userOperations() {
		while (true) {
			System.out.println("Press 1. Add User\nPress 2. Retrieve All Users\n"
					+ "Press 3. Update User\nPress 4. Delete User\nPress 5. To get back to the main menu");
			int input = sc.nextInt();
			sc.nextLine(); // consume the newline character

			switch (input) {
			case 1:
				// Add User
				User user = userInputs();
				User savedUser = userService.createUser(user);
				if (savedUser != null) {
					System.out.println("User has been saved successfully: " + savedUser);
				} else {
					System.out.println("Failed to save the user.");
				}
				break;

			case 2:
				// Retrieve All Users
				List<User> users = userService.getAllUsers();
				if (users != null && !users.isEmpty()) {
					for (User usr : users) {
						System.out.println(usr);
					}
				} else {
					System.out.println("No users found.");
				}
				break;

			case 3:
				// Update User
				System.out.println("Enter User ID to update:");
				String userId = sc.nextLine();
				User existingUser = userService.getUserById(userId);
				if (existingUser != null) {
					System.out.println("Enter new details for the user:");
					User updatedUser = userInputs(); // Assuming userInputs() will take user input for the update
					User updatedInfo = userService.updateUser(userId, updatedUser);
					if (updatedInfo != null) {
						System.out.println("User data has been updated successfully: " + updatedInfo);
					} else {
						System.out.println("Failed to update user.");
					}
				} else {
					System.out.println("User not found.");
				}
				break;

			case 4:
				// Delete User
				System.out.println("Enter User ID to delete:");
				String deleteUserId = sc.nextLine();
				String message = userService.deleteUserById(deleteUserId);
				System.out.println(message);
				break;

			case 5:
				// Return to main menu
				return;

			default:
				System.out.println("Invalid option. Please try again.");
			}
		}
	}


	//Admin Input method

	public static Admin adminInput() {
//		// Collect Admin ID from user
//		System.out.println("Enter Admin Id:");
//		String adminId = sc.nextLine();

		// Collect Parking Fees Type from user
		System.out.println("Enter Parking Fees Type:");
		String parkingFeesType = sc.nextLine();

		// Collect Per Module from user
		System.out.println("Enter Per Module:");
		String perModule = sc.nextLine();

		// Collect Per Name from user
		System.out.println("Enter the Date (yyyy-mm-dd):");
		String dateInput = sc.nextLine();
		Date date = Date.valueOf(dateInput);

		// Create and return a new Admin object using the provided constructor
		return new Admin( parkingFeesType, perModule, date);
	}

	//    Admin Opertaion method

	public static void adminOperations() {
		while (true) {
			System.out.println("Press 1. Add Admin\nPress 2. Retrieve All Admins\n"
					+ "Press 3. Update Admin\nPress 4. Delete Admin\nPress 5. To get back to the main menu");
			int input = sc.nextInt();
			sc.nextLine(); // Consume the newline character after int input

			switch (input) {
			case 1:
				Admin admin = adminInput();
				Admin savedAdmin = adminService.createAdmin(admin);
				System.out.println("Admin has been saved successfully: " + savedAdmin);
				break;

			case 2:
				List<Admin> admins = adminService.getAllAdmins();
				for (Admin ad : admins) {
					System.out.println(ad);
				}
				break;

			case 3:
				System.out.println("Enter Admin ID to update:");
				String adminId = sc.nextLine();
				Admin existingAdmin = adminService.getAdminById(adminId);
				if (existingAdmin != null) {
					Admin updatedAdmin = adminInput();
					Admin updatedInfo = adminService.updateAdmin(adminId, updatedAdmin);
					System.out.println("Admin data has been updated successfully: " + updatedInfo);
				} else {
					System.out.println("Admin not found");
				}
				break;

			case 4:
				System.out.println("Enter Admin ID to delete:");
				String deleteAdminId = sc.nextLine();
				String message = adminService.deleteAdminById(deleteAdminId);
				System.out.println(message);
				break;

			case 5:
				// Return to main menu
				return;

			default:
				System.out.println("Invalid input. Please try again.");
			}
		}
	}
	
	
	// car details input 
	

public class CarOperations {

    

    // Car Input method
    public static Car carInput() {
        // Collect Car Number from user
        System.out.println("Enter Car Number:");
        String carNumber = sc.nextLine();

        // Collect Car Type from user
        System.out.println("Enter Car Type:");
        String carType = sc.nextLine();

        // Collect Car Description from user
        System.out.println("Enter Car Description:");
        String carDescription = sc.nextLine();

        // Collect Car Category from user
        System.out.println("Enter Car Category:");
        String carCategory = sc.nextLine();

        // Create and return a new Car object using the provided constructor
        return new Car(carNumber, carType, carDescription, carCategory);
    }
	
	
	// car Details method 
    public static void carOperations() {
        while (true) {
            System.out.println("Press 1. Add Car\nPress 2. Retrieve All Cars\n"
                    + "Press 3. Update Car\nPress 4. Delete Car\nPress 5. To get back to the main menu");
            int input = sc.nextInt();
            sc.nextLine(); // Consume the newline

            switch (input) {
                case 1:
                    Car car = carInput();
                    Car savedCar = carService.createCar(car);
                    System.out.println("Car has been saved successfully: " + savedCar);
                    break;

                case 2:
                    List<Car> carList = carService.getAllCars();
                    for (Car carEntry : carList) {
                        System.out.println(carEntry);
                    }
                    break;

                case 3:
                    System.out.println("Enter Car Number to update:");
                    String carNumber = sc.nextLine();
                    Car existingCar = carService.getCarByNumber(carNumber);
                    if (existingCar != null) {
                        Car updatedCar = carInput();
                        Car updated = carService.updateCar(carNumber, updatedCar);
                        System.out.println("Car has been updated successfully: " + updated);
                    } else {
                        System.out.println("Car not found");
                    }
                    break;

                case 4:
                    System.out.println("Enter Car Number to delete:");
                    String deleteCarNumber = sc.nextLine();
                    String message = carService.deleteCarByNumber(deleteCarNumber);
                    System.out.println(message);
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid input. Please try again.");
            }
        }
    }
}
    
	// Parkingfees input 
	
public static ParkingFees parkingFeesInput() {
//    System.out.println("Enter Parking Fees ID:");
//    String parkingFeesId = sc.nextLine();

    System.out.println("Enter Parking Fees Type:");
    String parkingFeesType = sc.nextLine();

    System.out.println("Enter Parking Fees Description:");
    String parkingFeesDescription = sc.nextLine();

    System.out.println("Enter Parking Fees Date (YYYY-MM-DD):");
    String dateInput = sc.nextLine();
    Date parkingFeesDate = Date.valueOf(dateInput); // Convert string to SQL Date

    System.out.println("Enter Parking Fees Amount:");
    double parkingFeesAmount = sc.nextDouble();
    sc.nextLine(); // Consume the newline
    return new ParkingFees(parkingFeesType, parkingFeesDescription, parkingFeesDate, parkingFeesAmount);
}

	
	
	//  Parkingfees method
	
public static void parkingFeesOperations() {
    while (true) {
        System.out.println("Press 1. Add Parking Fees\nPress 2. Retrieve All Parking Fees\n"
                + "Press 3. Update Parking Fees\nPress 4. Delete Parking Fees\nPress 5. To get back to the main menu");
        int input = sc.nextInt();
        sc.nextLine(); // Consume the newline

        switch (input) {
            case 1:
                ParkingFees parkingFees = parkingFeesInput();
                ParkingFees savedFees = parkingFeesService.createParkingFees(parkingFees);
                System.out.println("Parking Fees has been saved successfully: " + savedFees);
                break;

            case 2:
                List<ParkingFees> feesList = parkingFeesService.getAllParkingFees();
                for (ParkingFees fees : feesList) {
                    System.out.println(fees);
                }
                break;

            case 3:
                System.out.println("Enter Parking Fees ID to update:");
                String feesId = sc.nextLine();
                ParkingFees existingFees = parkingFeesService.getParkingFeesById(feesId);
                if (existingFees != null) {
                    ParkingFees updatedFees = parkingFeesInput();
                    ParkingFees updated = parkingFeesService.updateParkingFees(feesId, updatedFees);
                    System.out.println("Parking Fees has been updated successfully: " + updated);
                } else {
                    System.out.println("Parking Fees not found");
                }
                break;

            case 4:
                System.out.println("Enter Parking Fees ID to delete:");
                String deleteFeesId = sc.nextLine();
                String message = parkingFeesService.deleteParkingFeesById(deleteFeesId);
                System.out.println(message);
                break;

            case 5:
                return;

            default:
                System.out.println("Invalid input. Please try again.");
        }
    }
}
}




