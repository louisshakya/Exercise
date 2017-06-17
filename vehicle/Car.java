package com.tutorial.vehicle;

public class Car {
	
	private boolean carRunning = false;
	private int acceleration = 0;
	private int maximumSpeed;
	
	public Car() {
		
	}
	
	
	
	public boolean isCarRunning() {
		return this.carRunning;
	}
	
	public void startCar() {
		this.acceleration =0;
		this.carRunning = true;
	}
	
	public void stopCar() {
		this.acceleration = 0;
		this.carRunning = false;
	}
	
	public void accelerateCar() {
		
		if (this.carRunning == true) {
		    this.acceleration = this.acceleration + 10;
		}
	}
	
	public void deaccelerateCar() {
		
		if (this.acceleration > 0) {
			this.acceleration = this.acceleration - 10;
		}
	}
	
	public int getAcceleration() {
		return this.acceleration;
	}



	public int getMaximumSpeed() {
		return this.maximumSpeed;
	}



	public void setMaximumSpeed(int maximumSpeed) {
		this.maximumSpeed = maximumSpeed;
	}
	
	
	
	
	
	
	
}
