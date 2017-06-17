package com.tutorial.vehicle;

import java.util.Scanner;

public class Entry {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner (System.in);
		System.out.println("Enter the max speed");
		int maxSpeed = sc.nextInt();
		
		Car car = new Car();
		car.setMaximumSpeed(maxSpeed);
		
		System.out.println("Starting my car...");
		car.startCar();
		System.out.println("Car running status:  " + car.isCarRunning());
		
		System.out.println("Stopping my car...");
		car.stopCar();
		System.out.println("Car running status:  " + car.isCarRunning());
		
		System.out.println("Pressing the acceleration pedal..");
		car.accelerateCar();
		System.out.println("The car speed is now " + car.getAcceleration() + " m/s^2");
		
		System.out.println("Pressing the break pedal..");
		car.deaccelerateCar();
		System.out.println("The car speed is now " + car.getAcceleration() + " m/s^2" );
		
		boolean loop = true;
		
		while (loop) {
			
			System.out.println("What do you want to do next? \n 1. Start \n 2. Stop \n 3. Accelerate \n 4. Deaccelerate \n 5. Exit");
			String upNext = sc.next();
		
			switch (upNext) {
		
			case "1" :
			
				if (car.getAcceleration() == 0 && car.isCarRunning() == true) {
				
					System.out.print("The car has started ");
					System.out.println("velocity = " + car.getAcceleration() + " m/s^2");
			
				} else if (car.getAcceleration() != 0 && car.isCarRunning() == true) {
					
					System.out.println("The car is already in motion with the velocity " + car.getAcceleration() + " m/s^2");
				
				} else {
				
					System.out.println("Starting my car...");
					car.startCar();
					System.out.println("Car running status:  " + car.isCarRunning());
				
				}
				
				break;
			
			case "2" :
			
				if (car.getAcceleration() == 0 ) {
				
					System.out.print("The car is already at rest and ");
					System.out.println("velocity = " + car.getAcceleration() + " m/s^2");
			
				} else {
				
					System.out.println("Stopping my car...");
					car.stopCar();
					System.out.println("Car running status:  " + car.isCarRunning());
					
				}
				
				break;
			
			case "3" :
			
				if (car.isCarRunning() == false) {
				
					System.out.println("The car is at rest. Do you want to start your car?(y/n)");
					String startCarAgain = sc.next();
					startCarAgain = startCarAgain.toLowerCase();
				
					if (startCarAgain.equals("y")) {
						
						System.out.println("Starting my car...");
						car.startCar();
						System.out.println("Car running status:  " + car.isCarRunning());
						
					} else if (startCarAgain.equals("n")) {
							
						System.out.println("Your car is at rest.");
						
					} else {
						
						System.out.println("Invalid");
					}
				
				} else if (car.getAcceleration() == car.getMaximumSpeed()) {
				
					System.out.println("you have met your max speed, you cannot accelerate further");
				
				} else {
					
					if (car.getMaximumSpeed() > 0) {
						
						System.out.println("Pressing the acceleration pedal..");
						car.accelerateCar();
						System.out.println("The car speed is now " + car.getAcceleration() + " m/s^2");
						
					} else {
						
						System.out.println("Can't accelerate. Maximum Velocity is not valid");
						System.out.println("Do you want to change the maximum velocity? (y/n)");
						String velocityChange = sc.next();
						velocityChange = velocityChange.toLowerCase();
						
						switch (velocityChange) {
						
						case "y" :
							boolean loopAgain = true;
							System.out.println("Enter the new Maximum Velocity");
							
							while (loopAgain) {
								
								maxSpeed = sc.nextInt();
								car.setMaximumSpeed(maxSpeed);
								if (car.getMaximumSpeed() > 0) {
							
									System.out.println("The new maximum velocity = " + car.getMaximumSpeed());
									loopAgain = false;
									
								} else {
								
									System.out.println("Maximum velocity can not be 0 or negative for the car to accelerate \n Enter the maximum velocity again");
								}
								
							}
							break;
							
						case "n" :
							
							System.out.println("The car cant operate with negative velocity");
							loop = false;
							
						}
					}		
				}
				
				break;
			
			case "4" :
			
				if (car.isCarRunning() == false) {
			
					System.out.println("The car is at rest. Do you want to start your car?(y/n)");
					String startCarAgain = sc.next();
					startCarAgain = startCarAgain.toLowerCase();
				
					if (startCarAgain.equals("y")) {
						
						System.out.println("Starting my car...");
						car.startCar();
						System.out.println("Car running status:  " + car.isCarRunning());
						
					} else if (startCarAgain.equals("n")) {
							
						System.out.println("your car is at rest ");
						
					} else {
						
						System.out.println("Invalid");
					}
						
				} else {
					
						if (car.getAcceleration() == 0) {
							
							System.out.println("The car is at rest.");
							
						} else {
					
							System.out.println("Pressing the break pedal..");
							car.deaccelerateCar();
							System.out.println("The car speed is now " + car.getAcceleration() + " m/s^2" );
							
						}
					}
				
				break;
				
			case "5" :
				
				System.out.println("Thankyou. Come back again");
				loop = false;
				
			break;
			
			default :
				
				System.out.println("Invalid");
				
			break;
		
			}
		}
	}
}
