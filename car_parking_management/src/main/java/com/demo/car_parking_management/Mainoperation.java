package com.demo.car_parking_management;

import java.util.Scanner;
import com.demo.car_parking_management.Alloperation;
import static com.demo.car_parking_management.Alloperation.userInputs;
//import static com.demo.car_parking_management.Alloperation.quizInputs;


public class Mainoperation {
	

	static Scanner sc=new Scanner(System.in);

	public static void mainOps()      //method
	{
		System.out.println("	Welcome..!!!	\n");
		while(true) {
			System.out.println("Press 1: User Details\n"
					+ "Press 2: Admin Deatils \n"
					+ "Press 3: Car Details\n"
					+ "Press 4: Parking Fees \n"
					+ "Press 5: Quit");
			int input=sc.nextInt();

			switch(input)
			{
			case 1:
				Alloperation.userOperations();
				System.out.println("=======================================");
				break;
			case 2:
				Alloperation.adminOperations();
				System.out.println("=======================================");
				break;

			case 3:
				Alloperation.CarOperations.carOperations();
				System.out.println("=======================================");
				break;				
			case 4:
				Alloperation.parkingFeesOperations();
				System.out.println("=======================================");
				break;


			case 5:
				System.out.println("Exiting the application.");
				System.exit(0);fault:
				System.out.println("WRONG INPUT");
			}
		}
	}

	public static void main(String[] args) 
	{
		
		
		
		mainOps();
	}

}