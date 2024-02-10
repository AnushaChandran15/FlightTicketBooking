package com.anushachandran1502.flightticketbooking.booking;

import com.anushachandran1502.flightticketbooking.dto.Flight;
import com.anushachandran1502.flightticketbooking.dto.Passenger;
import com.anushachandran1502.flightticketbooking.dto.Ticket;
import com.anushachandran1502.flightticketbooking.repository.Repository;

import java.util.*;

public class BookingViewModel {
	private BookingView bView;
	private Repository repo;
	public BookingViewModel(BookingView bookingView) {
		this.bView=bookingView;
		this.repo=Repository.getInstance();
	}

	public List<Flight> availableFlights(String from, String to) {
		List<Flight> fli=new ArrayList<Flight>();
		fli=repo.findFlightsByStations(from,to);
		return fli;
	}

	public Flight findTheFlight(int flightNo) {
		List<Flight> flights=repo.readFlightFile(); 
		for(Flight flight:flights)
		{
			if(flight.getFlightNumber()==flightNo)
			{
				return flight;
			}
		}
		return null;
	}

	public int ticketBooking(String from, String to, Flight flight,List<Passenger> passengers, int noOfPassenger, int totalFare) {
		Ticket ticket=new Ticket(from,to,flight,totalFare,passengers);
		flight.setTotalSeats((byte)(flight.getTotalSeats()-noOfPassenger));
		repo.getTickets().add(ticket);
		repo.writeFlightFile();
		repo.writeTicketFile();
		return ticket.getPNRNumber();
	}

	public void addFlightRoute(int flightNumber, List<String> newRoutes) {
		repo.addNewFlightRoutes(flightNumber,newRoutes);
		
	}

	public List<Ticket> bookedTickets() {
		return repo.getTickets();
	}

	 public Ticket findTicket(int PNRNumber)
	    {
	        for(Ticket ticket : repo.getTickets())
	        {
	            if(ticket.getPNRNumber() == PNRNumber)
	            {
	                return ticket;
	            }
	        }
	        return null;
	    }

	public String changeTicketStatus(int choice, int PNRNumber) {
        Ticket ticket = findTicket(PNRNumber);
        String[] status = new String[]{"CNF","CANCELLED"};

        for(Passenger passenger : ticket.getPassenger())
        {
            if(status[choice - 1].equals("CNF") && !passenger.getStatus().equals("CNF"))
            {
                Flight flight = findFlight(ticket.getFlight().getFlightNumber());
                flight.setTotalSeats((byte)(flight.getTotalSeats() - ticket.getPassenger().size()));
            }
            else if(status[choice - 1].equals("CANCELLED") && !passenger.getStatus().equals("CANCELLED"))
            {
                Flight flight = findFlight(ticket.getFlight().getFlightNumber());
                flight.setTotalSeats((byte)(flight.getTotalSeats() + ticket.getPassenger().size()));
            }
            passenger.setStatus(status[choice - 1]);
        }
        repo.writeFlightFile();
        repo.writeTicketFile();
        return status[choice - 1];
	}

	  public Flight findFlight(int flightNumber)
	    {
	        for(Flight flight : listFlights())
	        {
	            if(flight.getFlightNumber() == flightNumber)
	            {
	                return flight;
	            }
	        }
	        return null;
	    }
	    public List<Flight> listFlights()
	    {
	        return repo.getFlights();
	    }

	public Passenger findPassenger(int id) {
		for(Ticket ticket : repo.getTickets())
        {
            for(Passenger passenger : ticket.getPassenger())
            {
                if(passenger.getId() == id)
                {
                    return passenger;
                }
            }
        }
		return null;
	}

	public int cancelTicket(int PNRNumber) {
		Ticket ticket = findTicket(PNRNumber);
        Flight flight = findFlight(ticket.getFlight().getFlightNumber());
        flight.setTotalSeats((byte)(flight.getTotalSeats() + ticket.getPassenger().size()));
        for(Passenger passenger : ticket.getPassenger())
        {
            passenger.setStatus("Cancelled.....");
        }
        repo.writeFlightFile();
        repo.writeTicketFile();
        return ticket.getTotalFare();
	}

	

}
