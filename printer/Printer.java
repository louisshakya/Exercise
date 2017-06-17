package com.tutorial.printer;

public class Printer {
	
	private boolean printerRunning = false;
	private int maximumAllowedPaperInPrinter;
	private int numberOfPaper = 0;
	private int maximumPaperWithUser;
	private int numberOfPaperUserWantToAdd;	
	private boolean printerCablePluggedIn = false;
	private boolean powerButtonTurnedOn = false;	
	private int numberOfPaperUserWantToPrint;
	
	public Printer() {
		
	}
	
	public int getNumberOfPaperUserWantToPrint() {
		return numberOfPaperUserWantToPrint;
	}

	public void setNumberOfPaperUserWantToPrint(int numberOfPaperUserWantToPrint) {
		this.numberOfPaperUserWantToPrint = numberOfPaperUserWantToPrint;
	}
	
	public int getMaximumPaperWithUser() {
		return maximumPaperWithUser;
	}

	public void setMaximumPaperWithUser(int maximumPaperWithUser) {
		this.maximumPaperWithUser = maximumPaperWithUser;
	}
	
	public int getNumberOfPaperUserWantToAdd() {
		return numberOfPaperUserWantToAdd;
	}

	public void setNumberOfPaperUserWantToAdd(int numberOfPaperUserWantToAdd) {
		this.numberOfPaperUserWantToAdd = numberOfPaperUserWantToAdd;
	}

	public int getMaximumAllowedPaperInPrinter() {
		return maximumAllowedPaperInPrinter;
	}

	public void setMaximumAllowedPaperInPrinter(int maximumAllowedPaperInPrinter) {
		this.maximumAllowedPaperInPrinter = maximumAllowedPaperInPrinter;
	}
	
	public void insertPaper() {
		if (this.maximumPaperWithUser != 0) {
			if (this.numberOfPaper < this.maximumAllowedPaperInPrinter) {
				this.numberOfPaper = this.numberOfPaper + this.numberOfPaperUserWantToAdd;
				this.maximumPaperWithUser = this.maximumPaperWithUser - this.numberOfPaperUserWantToAdd;
			}
		}
	}
	
	public int numberOfPaper() {
		return this.numberOfPaper;
	}
	
/*	
	public int getMaximumPaperWithUser() {
		return maximumPaperWithUser;
	} */
	
	private void plugInPrinterCable() {
		if (!printerCablePluggedIn) {
		    printerCablePluggedIn = true;	
		}
	}
	
	private void plugOffPrinterCable() {
		if (printerCablePluggedIn) {
			printerCablePluggedIn = false;
		}
	}
	
	private void pushPowerButton() {
		if (printerCablePluggedIn) {
			if (powerButtonTurnedOn) {
				powerButtonTurnedOn = false;
			} else {
				powerButtonTurnedOn = true;
			}
		}
	}
	
	public boolean isPrinterRunning() {
		this.printerRunning = false;		
		if (powerButtonTurnedOn) {
			this.printerRunning = true;
		}
		return printerRunning;
	}
	
	public void turnOnPrinter() {
		plugInPrinterCable();
		pushPowerButton();
	}
	
	public void turnOffPrinter() { 
		pushPowerButton();
		plugOffPrinterCable();
		
	}
	
	
	
	
	
	
	/**
	 * TODO
	 */
	
	
	
	public boolean print() {
		//accept the number of pages to print. This can be a parameter to this method
		// if paper runs out, ask user to add more paper. See above for adding more paper and continue printing
		// you may also run out of the number of papers you actually have for example: 200 papers
		    // you buy printing papers (optional) => goto a shop, choose a printing paper, pay at counter, take home (Separate class for Buying)
		boolean print = false;
		if (isPrinterRunning() == true && numberOfPaper() > 0) {
			print = true;
			this.numberOfPaper = this.numberOfPaper -1;
		}
		return print;
	}
	

}
