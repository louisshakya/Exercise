package com.tutorial.printer;
import java.util.Scanner;

public class Entry {

	public static void main(String[] args) {
		String msg = "";
		boolean loop = true;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the maximum number of papers");
		int maxPaper = sc.nextInt();
		System.out.println("Enter the total number of papers you have.");
		int maxUserPaper = sc.nextInt();
		int paperUserInput =0;
		Printer printer = new Printer();
		printer.setMaximumAllowedPaperInPrinter(maxPaper);		
		printer.setMaximumPaperWithUser(maxUserPaper);
		while (loop) {
			System.out.println("What do you want to do? \n 1. TurnOn  \n 2. TurnOff \n 3. InsertPaper \n 4. Print \n 5. Exit");
			String upNext = sc.next();
		
			switch (upNext) {
				
			case "1" : //Turn ON Printer
				if (printer.isPrinterRunning() == true) {
					msg = "The printer is already running";
				} else {
					printer.turnOnPrinter();
					msg = "Printer cable plugged in. \nPower button on (Green light). \nPrinter is now turned on. \nPrinter status = " + printer.isPrinterRunning();
				} 
				
				break;
			
			case "2" : //Turn Off Printer
				if (printer.isPrinterRunning() == false) {
					msg = "The printer is already off";
				} else {
					printer.turnOffPrinter();
					msg = "Turning off printer power (Red Light). \nPrinter cable unplugged. \nPrinter status = " + printer.isPrinterRunning();
				}
				break;
			
			case "3" : //Insert Paper  //max allowed paper   max paper you have   number of paper you want to insert
				// insert paper should be less thn or equal to max paper
				// if insertpaper > maxpaper = max number reached
				// if insertpaper = 0 = add number of paper user wants -> max user paper - user input paper maxPaper - maxUserPaper
				// if maxUserPaper = 0 <- buy.java
				if(printer.getMaximumPaperWithUser() != 0) { 
					if (printer.numberOfPaper() < printer.getMaximumAllowedPaperInPrinter()) {	
						System.out.println("How many paper do you want to add?");			
						paperUserInput = sc.nextInt();
						printer.setNumberOfPaperUserWantToAdd(paperUserInput);
						if (printer.getNumberOfPaperUserWantToAdd() <= printer.getMaximumAllowedPaperInPrinter() && (printer.getNumberOfPaperUserWantToAdd() + printer.numberOfPaper()) <= printer.getMaximumAllowedPaperInPrinter()) {
							printer.getNumberOfPaperUserWantToAdd();
							printer.insertPaper();
							msg = "You have added paper \nTotal number of paper = " + printer.numberOfPaper();
						} else if ((printer.getNumberOfPaperUserWantToAdd() + printer.getMaximumAllowedPaperInPrinter()) > printer.getMaximumAllowedPaperInPrinter()) {
							msg = "Cannot add more than " + printer.getMaximumAllowedPaperInPrinter() + " papers in the printer";
						} else {
							msg = "You have only " + printer.getMaximumPaperWithUser() + " more paper left to add"; 
						}
					} else {
						msg = "Maximum number of paper reached. Can not add more paper";
					}
				} else {
					msg = "Out of paper";
				}
				break; 
				
			case "4" : //Print  //number of paper you want to print
				if (printer.print() == true) {
					System.out.println("How many paper do you want to print?");
					int numberOfPaperUserWantToPrint = sc.nextInt();
					printer.setNumberOfPaperUserWantToPrint(numberOfPaperUserWantToPrint);
					msg = "Printing............. \n \nDone printing\n";
				} else {
					System.out.println("Error while printing.");
					if (printer.numberOfPaper() == 0 && printer.isPrinterRunning() == true ) {
						msg = "Add paper";
					} else if (printer.isPrinterRunning() == false && printer.numberOfPaper() > 0 ) { // printer running = no , paper inserted = yes
						msg = "Turn on Printer to print.";
					} else {
						msg = "Insert paper and Turn on the printer to print.";
					}
				}
				
				break;
			
			case "5" : //Exit
				msg = "Thankyou for using the printer. Come Back Again.";
				loop = false;
				
				break;
			}
			
		System.out.println(msg);
		}
	}
}
