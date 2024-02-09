package com.anushachandran1502.flightticketbooking.base;

import java.util.Scanner;

import com.anushachandran1502.flightticketbooking.booking.BookingView;
public class BaseView {

	public void start() {
		do {
			Scanner scanner=new Scanner(System.in);
			System.out.println(" 1. Booking \n 2. Get PNR Status \n 3.Booked Tickets \n 4.Cancel Tickets \n 5. Search Passenger "
					+ "\n 6.Change ticket status of a Passenger"
					+ "\n 7. List Flight Routes \n 8. Add Flight Routes \n 0. Exit");
			System.out.println("Enter your option,");
			int choice=scanner.nextInt();
			switch(choice)
			{
				case 1: 
					new BookingView().ticketBooking();
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					break;
				case 0:
					break;
				default:
					System.out.println("Incorrect Option...");
			}
		}
		while(true);
		
	}

}
