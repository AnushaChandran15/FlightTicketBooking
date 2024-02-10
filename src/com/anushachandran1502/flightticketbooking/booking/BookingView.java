package com.anushachandran1502.flightticketbooking.booking;

import java.util.*;


import com.anushachandran1502.flightticketbooking.dto.Flight;
import com.anushachandran1502.flightticketbooking.dto.Passenger;
import com.anushachandran1502.flightticketbooking.dto.Ticket;
public class BookingView {
	private BookingViewModel bViewModel;
	Scanner scanner=new Scanner(System.in);

	public BookingView()
	{
		this.bViewModel=new BookingViewModel(this);
	}

	public void ticketBooking() {
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
		Flight flight=bViewModel.findTheFlight(flightNo);

		if(flight.getTotalSeats()==0)
		{
			System.out.println("No seats Available");
			return;
		}
		
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
		int totalFare=flight.getFare()*noOfPassenger;
		System.out.println("Total Fare :" + totalFare);
		System.out.println("Pay :");
		System.out.println("1. Pay \n 2. Cancel \n 3. Reschedule");
		int choice=scanner.nextInt();
		switch (choice) {
		case 1: 
				System.out.println("Ticket Booking SuccessFully.....");
				int PNRNumber=bViewModel.ticketBooking(from,to,flight,passengers,noOfPassenger,totalFare);
                System.out.println("Your PNRNumber: "+PNRNumber);
				
			break;
		case 2:
			break;
		case 3:
			break;
		
		default:
			System.out.println("Invalid...");
		}
		
		
	}

	public void addFlightRoutes() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the Flight Number");
		int flightNumber=scanner.nextInt();
		System.out.println("Enter the Number of Routes ");
		int noOfRoutes=scanner.nextInt();
		scanner.nextLine();
		List<String> newRoutes=new ArrayList<>();
		for(int i = 0;i<noOfRoutes;i++)
		{
			System.out.println("Enter the new route:");
			newRoutes.add(scanner.nextLine());
		}
			bViewModel.addFlightRoute(flightNumber,newRoutes);
	}

    public void getBookedTickets()
    {
        System.out.println("Total Tickets booked : "+bViewModel.bookedTickets().size());
        System.out.println();
        int index = 1;
        for(Ticket ticket : bViewModel.bookedTickets())
        {
            System.out.println("Ticket details "+index++);
            System.out.println(ticket);
            System.out.println();
        }
    }

    public void getPNRStatus()
    {
        System.out.println("Enter the PNR Number: ");
        int PNRNumber = scanner.nextInt();
        Ticket ticket = bViewModel.findTicket(PNRNumber);
        System.out.println(ticket);
    }

	public void changeTicketStatus() {
		System.out.println("Enter the PNR Number: ");
        int PNRNumber = scanner.nextInt();
        System.out.println("1.CNF\n2.CANCEL");
        int choice = scanner.nextInt();
        String status = bViewModel.changeTicketStatus(choice,PNRNumber);
        System.out.println("Ticket status updated as \""+status+"\"");
	}

	public void searchPassenger() {
		System.out.println("Enter Passenger ID:");
        int id = scanner.nextInt();
        Passenger passenger = bViewModel.findPassenger(id);
        System.out.println("Passenger details: ");
        System.out.println(passenger);

	}

	public void cancelTicket() {
		System.out.println("Enter the PNR Number: ");
        int PNRNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Do you want to cancel the ticket?(Yes/No)");
        String str = scanner.nextLine();
        if(str.equals("Yes"))
        {
            int total = bViewModel.cancelTicket(PNRNumber);
            System.out.println("Ticket Cancelled Successfully.Your refund "+total+" will be processed soon.");
        }
    }

	public void searchFlight() {
		System.out.println("From Station: ");
        String from = scanner.nextLine();
        System.out.println("To Station: ");
        String to = scanner.nextLine();
        for(Flight flight : bViewModel.availableFlights(from,to))
        {
            System.out.println(flight);
        }
		
	}
	



}
