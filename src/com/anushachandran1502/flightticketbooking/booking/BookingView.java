package com.anushachandran1502.flightticketbooking.booking;

import java.util.*;

import com.anushachandran1502.flightticketbooking.dto.Flight;
import com.anushachandran1502.flightticketbooking.dto.Passenger;
public class BookingView {
	private BookingViewModel bViewModel;
	public BookingView()
	{
		this.bViewModel=new BookingViewModel(this);
	}

	public void ticketBooking() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("From Station");
		String from=scanner.nextLine();
		System.out.println("To Station");
		String to=scanner.nextLine();
		int noOfFlights=1;
		System.out.println("Available Flights \n");
		
		for(Flight flight: bViewModel.availableFlights(from,to))
		{
			System.out.println("Flight"+ noOfFlights++ +flight);
			System.out.println();
		}
		System.out.println("Enter the Flight Number");
		int flightNo=scanner.nextInt();
		System.out.println("Enter the Number of Passenger");
		int noOfPassenger=scanner.nextInt();
		scanner.nextLine();
		List<Passenger> passengers=new ArrayList<Passenger>();
		for(int i=1;i<=noOfPassenger; i++)
		{
			System.out.println("Passenger :" + i);
			System.out.println("Name: ");
			String name=scanner.nextLine();
			System.out.println("Age: ");
			byte age=scanner.nextByte();
			scanner.nextLine();
			System.out.println("Gender: ");
			String gender=scanner.nextLine();
			System.out.println("Id: ");
			int id=scanner.nextInt();
			scanner.nextLine();
			passengers.add(new Passenger(name,age,gender,id));
		}
		Flight flight=bViewModel.findTheFlight(flightNo);
		int totalFare=flight.getFare()*noOfPassenger;
		System.out.println("Total Fare :" + totalFare);
		System.out.println("Pay :");
		System.out.println("1. Pay \n 2. Cancel \n 3. Reschedule");
		int choice=scanner.nextInt();
		switch (choice) {
		case 1: 
			if(noOfPassenger>1)
			{
				System.out.println("Tickets Booking SuccessFully.....");
				
			}
			else
			{
				System.out.println("Ticket Booking SuccessFully...");
			}
			break;
		case 2:
			break;
		case 3:
			break;
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		}
		
		
	}

}
