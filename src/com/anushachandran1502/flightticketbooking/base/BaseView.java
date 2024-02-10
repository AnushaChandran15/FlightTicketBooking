package com.anushachandran1502.flightticketbooking.base;

import java.util.Scanner;

import com.anushachandran1502.flightticketbooking.addflight.AddFlightView;
import com.anushachandran1502.flightticketbooking.booking.BookingView;
import com.anushachandran1502.flightticketbooking.dto.Flight;
public class BaseView {

	public void start() {
		AddFlightView addFlightView=new AddFlightView();
		BookingView bView=new BookingView();
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
					bView.ticketBooking();
					break;
				case 2:
					bView.getPNRStatus();
					break;
				case 3:
					
					break;
				case 4:
					bView.getBookedTickets();
					break;
				case 5:
                    bView.cancelTicket();
					break;
				case 6:
                    bView.searchPassenger();
					break;
				case 7:
					bView.changeTicketStatus();
					break;
				case 8:
					bView.addFlightRoutes();
					break;
				case 0:
					System.exit(0);
				default:
					System.out.println("Incorrect Option...");
			}
		}
		while(true);
		
	}

}
